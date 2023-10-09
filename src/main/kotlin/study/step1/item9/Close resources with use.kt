package study.step1.item9

import java.io.BufferedReader
import java.io.FileReader

// 리소스는 use를 사용해라
/*
- InputStream OutputSteam,
- java.sql.Connection,
- java.io.Reader
- java.util.Scanner
- java.new.Socket

이것들은 자동 닫기 인터페이스를 확장하는 닫기 가능 인터페이스를 구현합니다.

리소스가 다소 비싸고 자체적으로 쉽게 닫히지 않기 때문에 이러한 모든 경우에 리소스가 더이상 필요하지 않을때 닫기 메서드를 호추랳야함.

fun countCharactersInFile(path: String) : Int{
    val reader = BufferedReader(FileReader(path))
    try{
        return reader.lineSequence().sumBy{ it.length }
    }
    finally{
     reader.close()
    }
}

이러한 구조는 복잡하다.
닫으면 에러가 발생할 수 있고 잡히지 않는다고함.
try와 finally에ㅓ 모두 에러가 발생하면 하나만 전파댐.

fun countCharactersInFile(path: String) : Int{
    val reader = BufferedReader(FileReader(path))
    reader.use{
        return reader.lineSequence().sumBy{ it.length }
   }
}

use는 모든 Closable객체에 사용하 ㄹ수 있다.
 */
fun main() {

    val reader = BufferedReader(FileReader("")).use { // Closeable Interface를 상속하는 애들만 close를 쓸 수 있음.

    }

}
