package it.tmac12.kotlinnavdrawer

/**
 * Created by marco on 08/11/17.
 */
interface MainContract {
    interface View{
        fun showLoading()
        fun showFragment_One()
        fun showFragment_Two()
    }
    interface Presenter{
        fun start()
        //fun loadMain()
    }
}