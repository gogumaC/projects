package yubinkim.android_note.a2020_nov_week3_numbercompatition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

var total=0
var win=0
var lose=0
var draw=0
var message:String=""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val random= Random()        //java.util임포트함
        var max=50       //범위지정
        var comNum:Int      //comNum 선언
        var userNum:Int //userNum string타입으로 가져옴


        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Progress.text=progress.toString()
                max=progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })



        //버튼 누르고 일어나는 일
        btnStart.setOnClickListener {


            userNum=usernum.text.toString().toInt()

            if(userNum is Int)
            {

                Log.d("test","$userNum")

                comNum=random.nextInt(max+1)  //0~max까지 난수 발생시켜 comNum에할당
                Log.d("test","comNum:$comNum") //comNum 출력(tag:test)
                comnum.text=comNum.toString()       //comNum 을 텍스트박스에 보이기

                Log.d("test","여기까지")

                if(userNum.toInt()>max){
                    Toast.makeText(this,"범위 내 숫자를 입력해주세요",Toast.LENGTH_SHORT).show()
                }
                else
                    testNum(comNum,userNum.toInt())     //comNum과 userNum의 대소관계비교 및 기타연산
            }
            else
            {
                Toast.makeText(this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show()
            }




        }
    }



    fun testNum(comNum:Int,userNum:Int){

        if(comNum==userNum)
        {
            total+=1
            Total.text=total.toString()
            draw+=1
            message="비겼습니다"
        }

        else if(comNum>userNum)
        {
            total+=1
            Total.text=total.toString()
            lose+=1
            Lose.text=lose.toString()
            message="졌습니다"

        }

        else if(comNum<userNum){
            total+=1
            Total.text=total.toString()
            win+=1
            Win.text=win.toString()
            message="이겼습니다"
        }

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()      //승자표기

    }

}