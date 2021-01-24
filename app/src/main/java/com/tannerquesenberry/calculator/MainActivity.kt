package com.tannerquesenberry.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    private lateinit var operation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val viewModel: CalculatorViewModel by viewModels()
        val viewModel: BigDecimalViewModel by viewModels()

        viewModel.stringResult.observe(this, Observer<String> { stringResult -> result.setText(stringResult) })
        viewModel.stringNewNumber.observe(this, Observer<String> { stringNumber -> newNumber.setText(stringNumber)})
        viewModel.stringOperation.observe(this, Observer<String> { stringOperation -> operation.text = stringOperation })

        result = findViewById(R.id.result)
        newNumber = findViewById(R.id.newNumber)
        operation = findViewById(R.id.operation)

        // Data input buttons
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDot: Button = findViewById(R.id.buttonDot)

        // Operation buttons
        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonAdd.setOnClickListener(opListener)

        val buttonNeg: Button = findViewById(R.id.buttonNeg)
        buttonNeg.setOnClickListener { view ->
            viewModel.negPressed()

        }

    }

}