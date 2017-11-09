package it.tmac12.kotlinnavdrawer.view.fragment

import it.tmac12.kotlinnavdrawer.BaseView

/**
 * Created by marco on 08/11/17.
 */
interface FragmentOneContract {
    interface View: BaseView<Presenter>{

    }
    interface Presenter{
        fun start()
    }
}