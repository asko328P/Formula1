package com.example.formula1

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView

import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import org.w3c.dom.Text


class DriverDetailFragment : Fragment() {

    private val args: DriverDetailFragmentArgs by navArgs()
    private lateinit var driver: DriverParc


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_driver_detail, container, false)

        driver = args.driverParc


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView = view.findViewById<TextView>(R.id.textView18)
        val surNameTextView = view.findViewById<TextView>(R.id.textView19)
        val nationalityTextView = view.findViewById<TextView>(R.id.textView20)
        val dateOfBirthTextView = view.findViewById<TextView>(R.id.textView21)
        val racingNumberTextView = view.findViewById<TextView>(R.id.textView22)

        nameTextView.setText(driver.givenName)
        surNameTextView.setText(driver.familyName)
        nationalityTextView.setText(driver.nationality)
        dateOfBirthTextView.setText(driver.dateOfBirth)
        racingNumberTextView.setText(driver.permanentNumber)

        //val wikiUrl = driver.url
        var wikiUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Max_Verstappen_2017_Malaysia_3.jpg/133px-Max_Verstappen_2017_Malaysia_3.jpg"

        when (driver.driverId){
            "max_verstappen" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Max_Verstappen_2017_Malaysia_3.jpg/133px-Max_Verstappen_2017_Malaysia_3.jpg"
            "leclerc" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Charles-Leclerc.jpg/133px-Charles-Leclerc.jpg"
            "russell" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/George_Russell%2C_Silverstone_2021_%2851350033659%29_%28cropped%29.jpg/200px-George_Russell%2C_Silverstone_2021_%2851350033659%29_%28cropped%29.jpg"
            "sainz" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Formel12021-SchlossGabelhofen%2815%29_%28cropped%29.jpg/154px-Formel12021-SchlossGabelhofen%2815%29_%28cropped%29.jpg"
            "hamilton" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Lewis_Hamilton_2016_Malaysia_2.jpg/133px-Lewis_Hamilton_2016_Malaysia_2.jpg"
            "perez" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Sergio_P%C3%A9rez_2019_%28cropped%29.jpg/150px-Sergio_P%C3%A9rez_2019_%28cropped%29.jpg"
            "norris" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Lando_Norris_Formula_1_Driver_%2849379469418%29_%28cropped%29_%28cropped%29.jpg/164px-Lando_Norris_Formula_1_Driver_%2849379469418%29_%28cropped%29_%28cropped%29.jpg"
            "gasly" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Pierre_Gasly_2017_Malaysia.jpg/150px-Pierre_Gasly_2017_Malaysia.jpg"
            "de_vries" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Nyck_de_Vries_IAA_2019.jpg/119px-Nyck_de_Vries_IAA_2019.jpg"
            "zhou" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Zhou_Guanyu_at_the_2022_Austrian_Grand_Prix.jpg/133px-Zhou_Guanyu_at_the_2022_Austrian_Grand_Prix.jpg"
            "ocon" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Esteban_Ocon_2017_Malaysia_1.jpg/133px-Esteban_Ocon_2017_Malaysia_1.jpg"
            "mick_schumacher" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Mick_Schumacher_-_2022236170142_2022-08-24_Champions_for_Charity_-_Sven_-_1D_X_MK_II_-_0047_-_B70I2057.jpg/133px-Mick_Schumacher_-_2022236170142_2022-08-24_Champions_for_Charity_-_Sven_-_1D_X_MK_II_-_0047_-_B70I2057.jpg"
            "bottas" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Valtteri_Bottas_at_the_2022_Austrian_Grand_Prix.jpg/122px-Valtteri_Bottas_at_the_2022_Austrian_Grand_Prix.jpg"
            "tsunoda" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/2021_US_GP%2C_Tsunoda.jpg/168px-2021_US_GP%2C_Tsunoda.jpg"
            "latifi" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/FIA_F1_Austria_2022_Nicholas_Latifi_%28cropped%29.jpg/130px-FIA_F1_Austria_2022_Nicholas_Latifi_%28cropped%29.jpg"
            "kevin_magnussen" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Kevin_Magnussen%2C_2019_Formula_One_Tests_Barcelona_%28cropped%29.jpg/129px-Kevin_Magnussen%2C_2019_Formula_One_Tests_Barcelona_%28cropped%29.jpg"
            "ricciardo" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/F12019_Schloss_Gabelhofen_%2818%29.jpg/133px-F12019_Schloss_Gabelhofen_%2818%29.jpg"
            "stroll" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Lance_Stroll_2017_Malaysia_2.jpg/133px-Lance_Stroll_2017_Malaysia_2.jpg"
            "alonso" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Alonso_2016.jpg/160px-Alonso_2016.jpg"
            "vettel" -> wikiUrl="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Sebastian_Vettel_2015_Malaysia_podium_1.jpg/133px-Sebastian_Vettel_2015_Malaysia_podium_1.jpg"
        }

        val profileImage = view.findViewById<ImageView>(R.id.imageView3)
        Glide.with(this).load(wikiUrl).transform(CenterCrop(), RoundedCorners(78)).into(profileImage)




    }

}