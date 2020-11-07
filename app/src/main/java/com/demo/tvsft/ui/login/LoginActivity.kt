package com.demo.tvsft.ui.login

import OutputModel
import Users
import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.demo.tvsft.R
import com.demo.tvsft.adapter.AdapterRepo
import com.demo.tvsft.adapter.PaginationScrollListener

/**
 * By Jigar savaliya
 */
class LoginActivity : AppCompatActivity() {

    private val adapter: AdapterRepo = AdapterRepo(ArrayList());
    private lateinit var loginViewModel: LoginViewModel
    lateinit var loading:ProgressBar;
    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var ofset: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Init();
        initAdapter()
        GetDataInitial(ofset);

    }

    /**
     * Init adapter
     */
    private fun initAdapter() {

        val rv_user_items: RecyclerView = findViewById(R.id.rv_user_items);
        rv_user_items.adapter = adapter;

        rv_user_items.addOnScrollListener(object :
            PaginationScrollListener(rv_user_items.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true
                ofset += 10;
                //you have to call loadmore items to get more data
                GetDataInitial(ofset)
            }
        })
    }

    private fun GetDataInitial(ofset: Int) {
        loading.visibility = View.VISIBLE;
        loginViewModel.Getdata(ofset);
    }

    private fun Init() {
        loading = findViewById<ProgressBar>(R.id.loading)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }

        })

    }

    private fun updateUiWithUser(model: OutputModel) {
        isLastPage = !model.data.has_more
        adapter.AddData(model.data.users as ArrayList<Users>)

    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}
