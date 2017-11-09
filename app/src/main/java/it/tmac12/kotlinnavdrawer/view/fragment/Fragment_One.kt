package it.tmac12.kotlinnavdrawer.view.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_one.*
import it.tmac12.kotlinnavdrawer.MainContract
import it.tmac12.kotlinnavdrawer.R

/**
 * Created by marco on 08/11/17.
 */
class Fragment_One : Fragment(), FragmentOneContract.View {
    override lateinit var presenter: FragmentOneContract.Presenter

    /*
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    */

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Create the presenter
        presenter = FragmentOnePresenter()
        return inflater.inflate(R.layout.fragment_one, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView1.text = "Fragment 1 Loaded"
    }

    companion object {
        /*
        fun newInstance(): Fragment_One{
            val fragment = Fragment_One()
            return  fragment
        }
        */
        fun newInstance() = Fragment_One()
    }
}