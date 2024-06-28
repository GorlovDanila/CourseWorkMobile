package com.example.coursework.presentation

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursework.R
import com.example.coursework.databinding.FragmentColorBinding
import com.example.coursework.presentation.list.ColorAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coursework.presentation.presenter.ColorViewModel
import com.example.coursework.presentation.state.ColorScreenState
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File

internal class ColorFragment : Fragment(R.layout.fragment_color) {

    private var binding: FragmentColorBinding? = null
    private val viewModel: ColorViewModel by viewModel()
    private lateinit var colorAdapter: ColorAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentColorBinding.bind(view)
        colorAdapter = ColorAdapter()
        binding?.rvColors?.layoutManager = LinearLayoutManager(context)

        observeViewModel()

        viewModel.getRecommendations()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
            ).collect {
                when (it) {
                    is ColorScreenState.Empty -> {}
                    is ColorScreenState.Loading -> {}
                    is ColorScreenState.Content -> {
                        Timber.tag("colors").e(it.colors.toString())
                        colorAdapter.data = it.colors
                        binding?.rvColors?.adapter = colorAdapter
                    }
                }
            }
        }
    }

    private fun getFileFromUri(uri: Uri): File? {
        return try {
            val path = getPathFromUri(uri)
            path?.let { File(it) }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun getPathFromUri(uri: Uri): String? {
        return try {
            val inputStream = context?.contentResolver?.openInputStream(uri)
            val file = File(context?.cacheDir, "temp_file")
            inputStream?.use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_FILE_URI = "arg_file_uri"

        fun newInstance(uri: String) = ColorFragment().apply {
            Timber.tag("uri").e(uri)
            arguments = Bundle().apply {
                putString(ARG_FILE_URI, uri)
            }
        }
    }
}
