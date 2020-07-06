package kr.co.tjoeun.listview_20200706.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listview_20200706.R
import kr.co.tjoeun.listview_20200706.datas.Student

class StudentAdapter(val mContext : Context, val resId:Int, val mList: List<Student>) : ArrayAdapter<Student>(mContext, resId, mList){
    //만들 장소 (Main에서 this)

    //화면을 그려줄때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //position: == Array의 위치
        var tempRow = convertView //임시 Row로 null인지 확인, null이라면 inf로 채워준다.
        //받아본 임시 row가 null인가?
        if(tempRow == null){
            //만약 null 이라면, inf를 이용해서 tempRow를 채워주자.
            tempRow = inf.inflate(R.layout.student_list_item, null) 
             
        }
        
          //tempRow에는 null일 가능성이 없다.
        //진짜 row에는 절대 null이 아니게 된 (!! = null이 절대 아님) tempRow를 복사.
        val row = tempRow!!


        // **마무리 단계**
        //row의 내용을 실제에 맞게 변경
        //(그려줄 위치에 맞는(position) 실제 데이터를 가져오고
        val data = mList[position]

        //row의 컴포넌트들을 가져와서
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        //데이터 반영
        nameTxt.text = data.name
        addressTxt.text = data.address

        ageTxt.text = "${data.birthYear}세"
        
         //ListView에 이 row를 뿌려달라고 결과로 지정.
        return row
    }
}