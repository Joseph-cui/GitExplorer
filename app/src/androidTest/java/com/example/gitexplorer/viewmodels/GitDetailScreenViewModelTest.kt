package com.example.gitexplorer.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.gitexplorer.MainCoroutineRule
import com.example.gitexplorer.data.repository.GithubReposity
import com.example.gitexplorer.utilities.getValue
import com.example.gitexplorer.utilities.testRepo
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Created by Joseph Cui on 2024-08-06.
 */
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
class GitDetailScreenViewModelTest {

    private lateinit var viewModel: GitDetailScreenViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule: RuleChain = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var githubRepo: GithubReposity

    @Before
    fun setUp() {
        hiltRule.inject()

        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val savedStateHandle: SavedStateHandle = SavedStateHandle().apply {
            set("gitrepo", testRepo)
        }
        viewModel = GitDetailScreenViewModel(savedStateHandle, githubRepo)
    }

    @After
    fun tearDown() {
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = runTest {
        Assert.assertFalse(getValue(viewModel.gitRepo))
    }
}