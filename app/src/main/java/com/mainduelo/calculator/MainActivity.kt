package com.mainduelo.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private enum class State { FirstNumber, SecondNumber, SelectedOperator }
    private var currentState : State = State.FirstNumber
    
    private var buttonsNumber : MutableList<Button?> = mutableListOf()
    private var buttonsOperation : MutableList<Button?> = mutableListOf()
    private var buttonsOperationUnique : MutableList<Button?> = mutableListOf()

    private var buttonEqual : Button? = null
    private var buttonClear : Button? = null
    private var buttonDot : Button? = null
    private var textViewResult : TextView? = null

    private var firstNumber : Float = 0.0f
    private var secondNumber : Float = 0.0f
    private var selectedOperator : CharSequence = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
        initializeButtonsNumber()
        initializeButtonsOperation()
        initializeButtonsOperationUnique()

        initializeButtonOnActionNumber()
        initializeButtonOnActionOperation()
        initializeButtonOnActionOperationUnique()
        initializeButtonsOnAction()

        textViewResult = findViewById(R.id.result)
    }
    
    private fun selectedButtonNumber(text : CharSequence){
        if(currentState.equals(State.SelectedOperator)){
            textViewResult?.setText("")
            currentState = State.SecondNumber
        }

        setTextViewResult("${textViewResult!!.text}$text")

        if(currentState.equals(State.FirstNumber))
            stateFirstNumber()
        else
           stateSecondNumber()
    }

    private fun stateFirstNumber(){
        firstNumber = getTextViewResult()
    }

    private fun stateSecondNumber(){
        secondNumber = getTextViewResult()
    }

    private fun setTextViewResult(text : CharSequence){
        textViewResult?.setText(text)
    }

    private fun getTextViewResult() : Float{
        return textViewResult?.text.toString().toFloat()
    }

    private fun initializeButtonsNumber(){
        buttonsNumber = mutableListOf(
            findViewById(R.id.button_one),
            findViewById(R.id.button_two),
            findViewById(R.id.button_three),
            findViewById(R.id.button_four),
            findViewById(R.id.button_five),
            findViewById(R.id.button_six),
            findViewById(R.id.button_seven),
            findViewById(R.id.button_eight),
            findViewById(R.id.button_nine),
            findViewById(R.id.button_zero))
    }

    private fun initializeButtonsOperation(){
        buttonsOperation = mutableListOf(
            findViewById(R.id.button_plus),
            findViewById(R.id.button_minus),
            findViewById(R.id.button_division),
            findViewById(R.id.button_multiply))
    }

    private fun initializeButtonsOperationUnique(){
        buttonsOperationUnique = mutableListOf(
            findViewById(R.id.button_root),
            findViewById(R.id.button_percentage),
            findViewById(R.id.button_square))
    }

    private fun initializeButtons(){
        buttonEqual = findViewById(R.id.button_equal)
        buttonClear = findViewById(R.id.button_clear)
        buttonDot = findViewById(R.id.button_dot)
    }

    private fun initializeButtonOnActionNumber(){
        for(button in buttonsNumber){
            button!!.setOnClickListener {
                selectedButtonNumber(button.text)
            }
        }
    }

    private fun initializeButtonOnActionOperation(){
        for(button in buttonsOperation){
            button!!.setOnClickListener {
                currentState = State.SelectedOperator
                selectedOperator = button.text
            }
        }
    }

    private fun initializeButtonOnActionOperationUnique(){
        for(button in buttonsOperationUnique){
            button!!.setOnClickListener {
                setTextViewResult(Operator(button.text).getResultOperatorUnique(firstNumber).toString())
                firstNumber = getTextViewResult()
            }
        }
    }

    private fun  initializeButtonsOnAction(){
        buttonEqual?.setOnClickListener{
            startActivityCredits()
            setTextViewResult(Operator(selectedOperator).getResultOperator(firstNumber, secondNumber).toString())
            firstNumber = getTextViewResult()
            currentState = State.FirstNumber
        }

        buttonClear?.setOnClickListener{
            firstNumber = 0.0f
            secondNumber = 0.0f
            currentState = State.FirstNumber
            setTextViewResult("")
        }

        buttonDot?.setOnClickListener{
            setTextViewResult("${textViewResult?.text!!.toString().replace(".","")}.")
        }
    }

    private fun startActivityCredits(){
        if(firstNumber == 0.0009f)
            startActivity(Intent(this, CreditsActivity::class.java))
    }
}
