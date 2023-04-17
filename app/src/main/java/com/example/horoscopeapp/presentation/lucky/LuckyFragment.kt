package com.example.horoscopeapp.presentation.lucky

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.horoscopeapp.R
import com.example.horoscopeapp.databinding.FragmentLuckyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class LuckyFragment : Fragment() {

    private val viewModel by viewModels<LuckyViewModel>()
    private var _binding: FragmentLuckyBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLuckyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.textViewCard.animate().alpha(1f).duration = 1000
        binding.viewFrontContainer.viewCardFront
        binding.viewBackContainer.viewBack.setOnClickListener {
            preparedCard()
            flipCard()
        }
    }

    private fun flipCard() {
        try {
            with(binding) {
                viewFrontContainer.viewFront.isVisible = true
                val scale = requireContext().resources.displayMetrics.density
                val cameraDist = NUMBER_DENSITY * scale
                viewFrontContainer.viewFront.cameraDistance = cameraDist
                viewBackContainer.viewBack.cameraDistance = cameraDist

                val flipOutAnimatorSet = AnimatorInflater.loadAnimator(
                    requireContext(),
                    R.animator.flip_out
                ) as AnimatorSet

                flipOutAnimatorSet.setTarget(viewBackContainer.viewBack)

                val flipInAnimatorSet = AnimatorInflater.loadAnimator(
                    requireContext(),
                    R.animator.flip_in
                ) as AnimatorSet

                flipInAnimatorSet.setTarget(viewFrontContainer.viewFront)

                flipOutAnimatorSet.start()
                flipInAnimatorSet.start()

                flipOutAnimatorSet.doOnEnd { viewBackContainer.viewBack.isVisible = false }
            }
        } catch (e: Exception) {
            Log.e("LuckyFragment", e.toString())
        }
    }

    private fun preparedCard() {
        val image = when (Random.nextInt(0, 5)) {
            0 -> R.drawable.card_fool
            1 -> R.drawable.card_moon
            2 -> R.drawable.card_hermit
            3 -> R.drawable.card_star
            4 -> R.drawable.card_sun
            5 -> R.drawable.card_sword
            else -> R.drawable.card_reverse
        }

        binding.viewFrontContainer.viewCardFront.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                image
            )
        )
    }

    companion object {
        const val NUMBER_DENSITY = 8000
    }
}