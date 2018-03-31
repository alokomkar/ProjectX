package com.sortedwork.projectx.onboarding

import android.content.Context
import android.support.v4.app.Fragment
import com.sortedwork.projectx.auth.AuthPresenter
import com.sortedwork.projectx.auth.AuthView

/**
 * Created by Alok Omkar on 2018-03-31.
 */
open class OnBoardingBaseFragment : Fragment() {

    lateinit var onBoardingView : OnBoardingView
    lateinit var onBoardingPresenter : OnBoardingPresenter

    /**
     * Called when a fragment is first attached to its context.
     * [.onCreate] will be called after this.
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if( context is OnBoardingView ) onBoardingView = context
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to [Activity.onStart] of the containing
     * Activity's lifecycle.
     */
    override fun onStart() {
        super.onStart()
        onBoardingPresenter = OnBoardingPresenter(onBoardingView)
    }

    /**
     * Called when the view previously created by [.onCreateView] has
     * been detached from the fragment.  The next time the fragment needs
     * to be displayed, a new view will be created.  This is called
     * after [.onStop] and before [.onDestroy].  It is called
     * *regardless* of whether [.onCreateView] returned a
     * non-null view.  Internally it is called after the view's state has
     * been saved but before it has been removed from its parent.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        onBoardingPresenter.onDestroy()
    }
}