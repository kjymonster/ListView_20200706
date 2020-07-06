package kr.co.tjoeun.listview_20200706

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.listview_20200706.datas.Student

class MainActivity : AppCompatActivity() {

    //학생 목록을 담고 있는 변수
    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("김재영", "서울시 은평구", 1986))
        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
        mStudentList.add(Student("김미희", "서울시 중랑구", 1995))
        mStudentList.add(Student("박호준", "인천시 부평구", 1990))
        mStudentList.add(Student("이예원", "서울시 금천구", 1984))
        mStudentList.add(Student("조장우", "서울시 종로구", 1983))
        mStudentList.add(Student("채정실", "서울시 용산구", 1991))








    }
}