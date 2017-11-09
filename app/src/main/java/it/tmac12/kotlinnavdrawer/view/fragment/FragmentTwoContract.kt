package it.tmac12.kotlinnavdrawer.view.fragment

import it.tmac12.kotlinnavdrawer.BaseView

/**
 * Created by marco on 09/11/17.
 */
interface FragmentTwoContract {
    interface View: BaseView<Presenter> {

    }
    interface Presenter{
        fun start()
    }
}