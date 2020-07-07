package kr.co.tjoeun.listview_20200706

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20200706.adapters.StudentAdapter
import kr.co.tjoeun.listview_20200706.datas.Student

class MainActivity : AppCompatActivity() {

    //학생 목록을 담고 있는 변수
    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        mStudentList.add(Student("김재영", "서울시 은평구", 1986))
//        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
//        mStudentList.add(Student("김미희", "서울시 중랑구", 1995))
//        mStudentList.add(Student("박호준", "인천시 부평구", 1990))
//        mStudentList.add(Student("이예원", "서울시 금천구", 1984))
//        mStudentList.add(Student("조장우", "서울시 종로구", 1983))
//        mStudentList.add(Student("채정실", "서울시 용산구", 1991))

        //미뤄둔 어댑터 객체화를 실행
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        //완성된 어댑터를 리스트뷰와 연결
        studentListView.adapter = mAdapter

        //원래 어댑터를 먼저 연결하고 나서, 내용물을 추가해야함(어제는 미리 내용물부터 추가)
        mStudentList.add(Student("김재영", "서울시 은평구", 1986))
        mStudentList.add(Student("조경진", "서울시 은평구", 1988))
        mStudentList.add(Student("김미희", "서울시 중랑구", 1995))
        mStudentList.add(Student("박호준", "인천시 부평구", 1990))
        mStudentList.add(Student("이예원", "서울시 금천구", 1984))
        mStudentList.add(Student("조장우", "서울시 종로구", 1983))
        mStudentList.add(Student("채정실", "서울시 용산구", 1991))

        //어댑터에게 새로고침 시키기(new0707)
        mAdapter.notifyDataSetChanged()


        //20/07/07 이어서
        //학생 목록 리스트뷰의 이벤트 처리
        studentListView.setOnItemClickListener { parent, view, position, id ->

            //각 줄을 누르면 "눌린 사람의 이름"을 토스트로
            //눌린 사람이 누군지 (위에서부터 0번임)
            val clickedUser = mStudentList[position]

            //토스트로 눌린 사람 이름
            Toast.makeText(this, clickedUser.name, Toast.LENGTH_LONG).show()
        }

        //학생 목록 LongClink 이벤트 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            //오래 눌린 사람을 명단에서 삭제.
            mStudentList.removeAt(position)

            //삭제시도하면 앱이 죽으므로, 어댑터에게 새로고침 시키기
            mAdapter.notifyDataSetChanged()

            // LongClick은 반드시 Boolean값을 리턴해 줘야함.
            return@setOnItemLongClickListener true


        }


    }
}