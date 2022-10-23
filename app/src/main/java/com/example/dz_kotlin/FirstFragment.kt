package com.example.dz_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.VectorEnabledTintResources
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dz_kotlin.databinding.ActivityMainBinding
import com.example.dz_kotlin.databinding.FragmentFirstBinding
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var count = 0
    private lateinit var nextFragment: NextFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPlus.setOnClickListener {
            count = count.inc()
            binding.tvZero.text = count.toString()
            if (count >= 10) {
                binding.btnPlus.visibility = View.GONE
                binding.btnMinus.visibility = View.VISIBLE
            }
            nextFragment=NextFragment()
        }
        binding.btnMinus.setOnClickListener {
            count = count.dec()
            binding.tvZero.text = count.toString()
            if (count<=0){

                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,nextFragment).addToBackStack(null).commit()
            }

        }
    }
}



