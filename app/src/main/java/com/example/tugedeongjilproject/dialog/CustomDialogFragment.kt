package com.example.tugedeongjilproject.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.tugedeongjilproject.databinding.FragmentCustomdialogBinding

class CustomDialogFragment : DialogFragment() {

    private var _binding: FragmentCustomdialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding =  FragmentCustomdialogBinding.inflate(inflater, container, false)
        val view = binding.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        initDialog()
        return view
    }

    private fun initDialog() {
        binding.title.text=arguments?.getString("title")
        binding.content.text=arguments?.getString("context")
        val btnBundle = arguments?.getStringArray("btnData")

        binding.noButton.setOnClickListener {
            buttonClickListener.onButton1Clicked()
            dismiss()
        }
        binding.noButton.text=btnBundle?.get(0)

        if(btnBundle?.size==1){
            binding.yesButton.visibility=View.GONE

        }else{
            binding.yesButton.setOnClickListener {
                buttonClickListener.onButton2Clicked()
                dismiss()
            }
            binding.yesButton.text=btnBundle?.get(1)
        }
    }

    interface OnButtonClickListener{
        fun onButton1Clicked()
        fun onButton2Clicked()
    }

    override fun onStart() {
        super.onStart();
        val lp : WindowManager.LayoutParams  =  WindowManager.LayoutParams()
        lp.copyFrom(dialog!!.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        val window: Window = dialog!!.window!!
        window.attributes =lp
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setButtonClickListener(buttonClickListener: OnButtonClickListener) {
        this.buttonClickListener = buttonClickListener
    }

    private lateinit var buttonClickListener: OnButtonClickListener

}