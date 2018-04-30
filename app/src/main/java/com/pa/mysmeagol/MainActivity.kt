package com.pa.mysmeagol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.util.*
import javax.xml.datatype.DatatypeConstants.DAYS
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    //// the birth date of smeagol in this variable
    //// todo: use one variable for this
    val birthDate = GregorianCalendar(2017, 3, 30).time
    val dob = "03/30/2017"

    //// the name of smeagol
    val catName = "Smeagol"


    //// the gender of smeagol
    val sex = "He"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        displayCatAge()
        calcDaysUntilBirthday()
        displayHumanAge()
    }


    fun calcDaysUntilBirthday() {


        val earlier = Calendar.getInstance()
        val later = Calendar.getInstance()

        val userDay: Int
        val currentDay: Int
        val currentYear: Int
        val currentMonth: Int
        val delimeter = "/"
        val bDate = dob.split(delimeter.toRegex(), 3).toTypedArray()

        currentYear = earlier.get(Calendar.YEAR)
        currentMonth = earlier.get(Calendar.MONTH)
        currentDay = earlier.get(Calendar.DATE)

        earlier.set(currentYear, currentMonth, currentDay)



        if (earlier.get(Calendar.MONTH) >= later.get(Calendar.MONTH)) {
            later.set(currentYear + 1, Integer.valueOf(bDate[0]), Integer.valueOf(bDate[1]))
        } else
            later.set(currentYear, Integer.valueOf(bDate[0]), Integer.valueOf(bDate[1]))

        val earlierDays = earlier.get(Calendar.DAY_OF_YEAR)
        val laterDays = later.get(Calendar.DAY_OF_YEAR)
        val daysUntilBirthday = (laterDays - earlierDays).toLong()


        println(daysUntilBirthday)

        textBirthday.text = sex + " " + "birthday is in" + " " + daysUntilBirthday + " " + "days!"
    }



    fun displayCatAge() {


        val msDiff = Calendar.getInstance().timeInMillis - oldCalendarDate.getTimeInMillis()
        val daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff)


        textAge.text = catName + " " + "is" + " " + diffYear + " " + "years" + ", " + diffMonth + " " + "months" + " " + "and" + " " + days + " " + "days old today."
    }



    fun displayHumanAge() {

        //// getting months different between two dates. This is the amount of months between the birth date and the current date.
        val startCalendar = GregorianCalendar()
        startCalendar.setTime(birthDate)
        val endCalendar = GregorianCalendar()
        endCalendar.getTime()
        val diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR)
        val diffMonth = diffYear * 12 + 1 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH)

        println(diffMonth)



        if (diffMonth < 1) {
            textHumanYears.text = "That is less than 1 year old in human years."
            textAgeGroup.text = catName + " " + "is an infant."
        } else if (diffMonth == 1) {
            textHumanYears.text = "That is less than 1 year old in human years."
            textAgeGroup.text = catName + " " + "is an infant."
        } else if (diffMonth == 2) {

            textHumanYears.text = "That is 3 years old in human years."
            textAgeGroup.text = catName + " " + "is a toddler."
        } else if (diffMonth == 3) {

            textHumanYears.text = "That is 4.5 years old in human years."
            textAgeGroup.text = catName + " " + "is starting kindergarten soon."
        } else if (diffMonth == 4) {

            textHumanYears.text = "That is 6 years old in human years."
            textAgeGroup.text = catName + " " + "has been in school for a little bit."
        } else if (diffMonth == 5) {

            textHumanYears.text = "That is 7.5 years old in human years."
            textAgeGroup.text = catName + " " + "is still growing."
        } else if (diffMonth == 6) {

            textHumanYears.text = "That is 9 years old in human years."
            textAgeGroup.text = catName + " " + "is still growing."
        } else if (diffMonth == 7) {

            textHumanYears.text = "That is 10 years old in human years."
            textAgeGroup.text = catName + " " + "is going to be a pre-teen soon."
        } else if (diffMonth == 8) {

            textHumanYears.text = "That is 11 years old in human years."
            textAgeGroup.text = catName + " " + "is a pre-teen."
        } else if (diffMonth == 9) {

            textHumanYears.text = "That is 12 years old in human years."
            textAgeGroup.text = catName + " " + "is a pre-teen."
        } else if (diffMonth == 10) {

            textHumanYears.text = "That is 13 years old in human years."
            textAgeGroup.text = catName + " " + "is officially a teenager."
        } else if (diffMonth == 11) {

            textHumanYears.text = "That is 14 years old in human years."
            textAgeGroup.text = catName + " " + "is a teenager."
        } else if (diffMonth == 12) {
            //// 1 years old

            textHumanYears.text = "That is 15 years old in human years."
            textAgeGroup.text = catName + " " + "is a teenager."
        } else if (diffMonth in 13..18) {
            //// 1.5 years old

            textHumanYears.text = "That is about 20 years old in human years."
            textAgeGroup.text = catName + " " + "is officially an adult."
        } else if (diffMonth in 19..24) {

            textHumanYears.text = "That is about 24 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (diffMonth in 25..36) {
            //// 3 years old

            textHumanYears.text = "That is about 28 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (diffMonth in 37..48) {

            textHumanYears.text = "That is about 32 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (diffMonth in 49..60) {
            //// 5 years old

            textHumanYears.text = "That is about 36 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (diffMonth in 61..72) {

            textHumanYears.text = "That is about 40 years old in human years."
            textAgeGroup.text = catName + " " + "is an adult."
        } else if (diffMonth in 73..84) {
            //// 7 years old

            textHumanYears.text = "That is about 44 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (diffMonth in 85..96) {

            textHumanYears.text = "That is about 48 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (diffMonth in 97..108) {
            //// 9 years old

            textHumanYears.text = "That is about 52 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult."
        } else if (diffMonth in 109..120) {
            //// 10 years old

            textHumanYears.text = "That is about 56 years old in human years."
            textAgeGroup.text = catName + " " + "is a mature adult and will soon be a senior citizen."
        } else if (diffMonth in 121..132) {
            //// 11 years old

            textHumanYears.text = "That is about 60 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (diffMonth in 133..144) {
            //// 12 years old

            textHumanYears.text = "That is about 64 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (diffMonth in 145..156) {
            //// 13 years old

            textHumanYears.text = "That is about 68 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (diffMonth in 157..168) {
            //// 14 years old

            textHumanYears.text = "That is about 72 years old in human years."
            textAgeGroup.text = catName + " " + "is a a senior citizen."
        } else if (diffMonth in 169..180) {
            //// 15 years old

            textHumanYears.text = "That is about 76 years old in human years."
            textAgeGroup.text = catName + " " + "is a geriatric senior citizen."


                //// todo: add more ages

        }



    }


    }







