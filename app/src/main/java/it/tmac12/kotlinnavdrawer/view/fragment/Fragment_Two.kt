package it.tmac12.kotlinnavdrawer.view.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.tmac12.kotlinnavdrawer.R
import kotlinx.android.synthetic.main.fragment_one.*

/**
 * Created by marco on 08/11/17.
 */
class Fragment_Two : Fragment(), FragmentTwoContract.View {
    override lateinit var presenter: FragmentTwoContract.Presenter

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Create the presenter
        presenter = FragmentTwoPresenter()
        return inflater.inflate(R.layout.fragment_two, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView1.text = "Fragment 2 Loaded"
    }

    companion object {

        fun newInstance() = Fragment_Two()
    }

}