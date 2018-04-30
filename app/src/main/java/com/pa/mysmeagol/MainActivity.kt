package com.pa.mysmeagol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.util.*
import javax.xml.datatype.DatatypeConstants.DAYS
import java.util.concurrent.TimeUnit

import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {


    //// the birth date of smeagol in this variable
    val dateofbirth = "2011/02/23"

    //// the name of smeagol
    val catName = "Smeagol"


    //// the gender of smeagol
    val sex = "His"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        displayAges()


    }


    fun displayAges() {

        //// create the date format:
        val sdf = SimpleDateFormat("yyyy/MM/dd")
        //// parse the dateofbirth variable into a new variable dob:
        val dob = sdf.parse(dateofbirth)
        //// convert the dob variable time to millis:
        val dobTimeInMillis = dob.getTime()
        //// subtract dob millis from the current date's millis
        val msDiff = Calendar.getInstance().timeInMillis - dobTimeInMillis;
        val calDiff = Calendar.getInstance()
        calDiff.timeInMillis = msDiff

        //// put the data into a string variable and put into the text view
        val msgCatAge = "${calDiff.get(Calendar.YEAR) - 1970} years, ${calDiff.get(Calendar.MONTH)} months, and ${calDiff.get(Calendar.DAY_OF_YEAR - 1)} days"
        textAge.text = catName + " " + "is" + " " + msgCatAge + " " + "old today."


        //// convert millis from the date difference into months
        var realmonths = msDiff / 86400000 / 31


        //// days until birthday
        var dt: Date? = null

        dt = sdf.parse(dateofbirth)
        val BDay = Calendar.getInstance()
        BDay.time = dt
        val today = Calendar.getInstance()
        //// Take your DOB Month and compare it to current month
        val BMonth = BDay.get(Calendar.MONTH)
        val CMonth = today.get(Calendar.MONTH)
        BDay.set(Calendar.YEAR, today.get(Calendar.YEAR))
        if (BMonth <= CMonth) {
            BDay.set(Calendar.YEAR, today.get(Calendar.YEAR) + 1)
        }
        //// Result in millis
        val millis = BDay.timeInMillis - today.timeInMillis
        //// Convert to days
        val days = millis / 86400000 + 1
        val sdf2 = SimpleDateFormat("EEEE")






        textBirthday.text = sex + " " + "birthday is in" + " " + days + " " + "days!"


        //// start the if else for text output
        if (realmonths < 1) {
            textHumanYears.text = "That is less than 1 year old in human years."
            textAgeGroup.text = catName + " " + "is an infant."
        } else if (realmonths == 1L) {
            textHumanYears.text = "That is less than 1 year old in human years."
            textAgeGroup.text = catName + " " + "is an infant."
        } else if (realmonths == 2L) {

            textHumanYears.text = "That is 3 years old in human years."
            textAgeGroup.text = catName + " " + "is a toddler."
        } else if (realmonths == 3L) {

            textHumanYears.text = "That is 4.5 years old in human years."
            textAgeGroup.text = catName + " " + "is starting kindergarten soon."
        } else if (realmonths == 4L) {

            textHumanYears.text = "That is 6 years old in human years."
            textAgeGroup.text = catName + " " + "has been in school for a little bit."
        } else if (realmonths == 5L) {

            textHumanYears.text = "That is 7.5 years old in human years."
            textAgeGroup.text = catName + " " + "is still growing."
        } else if (realmonths == 6L) {

            textHumanYears.text = "That is 9 years old in human years."
            textAgeGroup.text = catName + " " + "is still growing."
        } else if (realmonths == 7L) {

            textHumanYears.text = "That is 10 years old in human years."
            textAgeGroup.text = catName + " " + "is going to be a pre-teen soon."
        } else if (realmonths == 8L) {

            textHumanYears.text = "That is 11 years old in human years."
            textAgeGroup.text = catName + " " + "is a pre-teen."
        } else if (realmonths == 9L) {

            textHumanYears.text = "That is 12 years old in human years."
            textAgeGroup.text = catName + " " + "is a pre-teen."
        } else if (realmonths == 10L) {

            textHumanYears.text = "That is 13 years old in human years."
            textAgeGroup.text = catName + " " + "is officially a teenager."
        } else if (realmonths == 11L) {

            textHumanYears.text = "That is 14 years old in human years."
            textAgeGroup.text = catName + " " + "is a teenager."
        } else if (realmonths == 12L) {
            //// 1 years old

            textHumanYears.text = "That is 15 years old in human years."
            textAgeGroup.text = catName + " " + "is a teenager."
        } else if (realmonths in 13..18) {
            //// 1.5 years old

            textHumanYears.text = "That is about 20 years old in human years."
            textAgeGroup.text = catName + " " + "is officially an adult."
        } else if (realmonths in 19..24) {

            textHumanYears.text = "That is about 24 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (realmonths in 25..36) {
            //// 3 years old

            textHumanYears.text = "That is about 28 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (realmonths in 37..48) {

            textHumanYears.text = "That is about 32 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (realmonths in 49..60) {
            //// 5 years old

            textHumanYears.text = "That is about 36 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (realmonths in 61..72) {

            textHumanYears.text = "That is about 40 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (realmonths in 73..84) {
            //// 7 years old

            textHumanYears.text = "That is about 44 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (realmonths in 85..96) {

            textHumanYears.text = "That is about 48 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (realmonths in 97..108) {
            //// 9 years old

            textHumanYears.text = "That is about 52 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (realmonths in 109..120) {
            //// 10 years old

            textHumanYears.text = "That is about 56 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult and will soon be a senior citizen."
        } else if (realmonths in 121..132) {
            //// 11 years old

            textHumanYears.text = "That is about 60 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (realmonths in 133..144) {
            //// 12 years old

            textHumanYears.text = "That is about 64 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (realmonths in 145..156) {
            //// 13 years old

            textHumanYears.text = "That is about 68 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (realmonths in 157..168) {
            //// 14 years old

            textHumanYears.text = "That is about 72 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (realmonths in 169..180) {
            //// 15 years old

            textHumanYears.text = "That is about 76 years old in human years."
            textAgeGroup.text = catName + " " + "is a geriatric senior citizen."


            //// todo: add more ages

        }
    }
}
















