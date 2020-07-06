package kr.co.tjoeun.listview_20200706.datas

import java.util.*

class Student (val name:String, val address: String, val birthYear: Int){

    //함수로 나이 연산 기능 추가
    fun getKoreanAge() : Int {

        //실제 앱을 켤때마다 해당 연도의 나이가 계산되도록
        val now = Calendar.getInstance()

       // return 2020 - this.birthYear + 1
        return now.get(Calendar.YEAR) - this.birthYear + 1
    }
}