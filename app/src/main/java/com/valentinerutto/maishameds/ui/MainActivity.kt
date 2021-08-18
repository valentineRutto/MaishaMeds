package com.valentinerutto.maishameds.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valentinerutto.maishameds.R
import com.valentinerutto.maishameds.data.PostBody
import com.valentinerutto.maishameds.databinding.ActivityMainBinding
import com.valentinerutto.maishameds.ui.viewmodel.PostsViewModel
import com.valentinerutto.maishameds.util.NetworkResult
import com.valentinerutto.maishameds.util.makeAlertDialog
import com.valentinerutto.maishameds.util.makeProgressDialog
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
private val postsViewModel: PostsViewModel  by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnclickListener()

    }

    private fun setOnclickListener(){

        binding.fabPost.setOnClickListener {
        createPost()
        }

    }

    private fun createPost(){
       val dialog = makeProgressDialog(getString(R.string.dialog_title),this@MainActivity)
        dialog.show()
        var title = binding.etTitle.text.toString().trim()
        var post = binding.etPost.text.toString().trim()
     val userId = Math.random().toInt()
        if (title.isEmpty() || post.isEmpty()){
            binding.post.error = getString(R.string.empty_error_message)

        }else {
      MainScope().launch {
          postsViewModel.createPost(PostBody(post, title,userId))
           when(val createPost = postsViewModel.createPost(PostBody(post, title,userId))){

               is NetworkResult.Loading ->{
                   dialog.show()
               }
               is NetworkResult.Success ->{
                   dialog.dismiss()
                   makeAlertDialog(getString(R.string.post_success),getString(R.string.success)).show()
                   binding.etTitle.text?.clear()
                   binding.etPost.text?.clear()
                   title = ""
                   post = ""

               }
               is NetworkResult.NetworkError ->{
                   dialog.dismiss()
                   makeAlertDialog(getString(R.string.network_error),getString(R.string.network_error)).show()

               }
               is NetworkResult.ServerError ->{
                   dialog.dismiss()
                   makeAlertDialog(createPost.errorBody?.message?:getString(R.string.server_error),getString(R.string.server_error)).show()
               }

           }

            }

        }




    }

}