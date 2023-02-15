package com.example.flashcard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flashcard.databinding.ActivityQuizBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private var questionBank: Array<Question?> = arrayOfNulls<Question>(10)
    private var ind: Int = 0
    private var score: Int = 0
    private var username = ""
    private var inGame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getState(savedInstanceState)

        setListeners()
    }

    private fun getState(savedInstanceState: Bundle?) {
        val extras = intent.extras
        if (extras != null && username!="") {
            username = extras.getString("Username").toString()
            showSnackBar("Welcome back "+extras.getString("Username")+"!!")
        }

        if (savedInstanceState != null){
            ind = savedInstanceState.getInt("index")
            score = savedInstanceState.getInt("score")
            questionBank = savedInstanceState.getParcelableArray("questionBank") as Array<Question?>
            inGame = savedInstanceState.getBoolean("inGame")
            if(inGame)
                setUpView()
        }
    }

    private fun setListeners() {
        binding.newGame.setOnClickListener {
            startGame()
            questionBank = createQuestions(10)
            setUpView()
        }

        binding.submit.setOnClickListener{
            nextQuestion()
        }

        binding.answer.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                nextQuestion()
                return@OnKeyListener true
            }
            false
        })

        binding.restartGame.setOnClickListener{
            endGame()
            binding.newGame.performClick()
        }

        binding.quitGame.setOnClickListener{
            endGame()
        }

        binding.signout.setOnClickListener{
            val myIntent = Intent(this@QuizActivity, LoginActivity::class.java)
            this.startActivity(myIntent)
            this.finish()
        }
    }

    private fun startGame() {
        binding.mainMenu.visibility = View.INVISIBLE
        binding.quizLayout.visibility = View.VISIBLE
        binding.restartGame.visibility = View.VISIBLE
        binding.quitGame.visibility = View.VISIBLE
    }

    private fun nextQuestion() {

        var ans = binding.answer.text.toString()
        ans = ans.replace("\n","")

        println("ind  "+ind.toString())
        println(ind == 9)
        if(ans.toIntOrNull()==null)
        {
            println("test")
            Toast.makeText(this,"Invalid! Enter a number", Toast.LENGTH_SHORT).show()
            binding.answer.setText("")
        }
        else if(ind == 9)
        {
            if (ans.toInt() == (questionBank[ind]?.calcOutput() ?: 0))
                score+=1
            binding.answer.setText("")
            endGame()
        }
        else
        {
            if (ans.toInt() == (questionBank[ind]?.calcOutput() ?: 0))
                score+=1
            ind+=1
            setUpView()
            println(score)
            binding.answer.setText("")
        }
    }

    private fun endGame() {
        binding.answer.clearFocus()
        binding.mainMenu.visibility = View.VISIBLE
        binding.quizLayout.visibility = View.GONE
        binding.restartGame.visibility = View.INVISIBLE
        binding.quitGame.visibility = View.INVISIBLE

        if(ind>=9)
        {
            Toast.makeText(this,"Your score is "+score.toString(),Toast.LENGTH_LONG).show()
        }

        score=0
        ind=0
        inGame = false
        closeKeyboard()
    }

    private fun setUpView() {
        startGame()
        inGame = true
        binding.questionNo.setText((ind+1).toString())
        questionBank[ind]?.let { binding.firstNumber.setText(it.num1.toString()) }
        questionBank[ind]?.let { binding.secondNumber.setText(it.num2.toString()) }
        binding.operator.setText(questionBank[ind]?.op ?: "")

        var editText = binding.answer
        editText.requestFocus()
//        showKeyboard()
    }

    fun createQuestions(n: Int): Array<Question?> {
        val questionBank = arrayOfNulls<Question>(n)

        for (i in 0..n-1)
        {
            var op = Random.nextInt(0, 100)
            if(op>50)
                questionBank[i] = Question(Random.nextInt(1, 99),Random.nextInt(1, 20),"+")
            else
                questionBank[i] = Question(Random.nextInt(1, 99),Random.nextInt(1, 20),"-")
//            questionBank[i]?.let { println(it.num1.toString() + " " + it.num2.toString() + " " + it.op.toString() + " " + it.calcOutput().toString() ) }
        }

        return questionBank
    }

    fun showKeyboard() {
        val inputMethodManager: InputMethodManager =
            applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun closeKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.answer.windowToken, 0)
    }

    private fun showSnackBar(text: String) {
        Snackbar
            .make(
                binding.root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
//        private lateinit var questionBank: Array<Question?>
//        private var ind: Int = 0
//        private var score: Int = 0
//        private var username = ""
//        private var inGame = false

        savedInstanceState.putParcelableArray("questionBank", questionBank)
        savedInstanceState.putInt("index", ind)
        savedInstanceState.putBoolean("inGame", inGame)
        savedInstanceState.putInt("score", score)

//        savedInstanceState.putBoolean("clear", clear)
//        savedInstanceState.putBoolean("operator", operator)
//        savedInstanceState.putBoolean("decimal", decimal)
    }

}