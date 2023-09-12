package com.example.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentapp.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val args: SecondFragmentArgs by navArgs()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewThird.text = buildString {
            append("Look at this, ")
            append(args.personname)
            append("!")
    }

        binding.buttonThirdPrevious.setOnClickListener {
            val name = args.personname
            val age = args.personage
            val person = args.person
            val action = ThirdFragmentDirections.actionThirdFragmentToSecondFragment(name, age, person)
            findNavController().navigate(action)
        }
        binding.buttonThirdStart.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToFirstFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}