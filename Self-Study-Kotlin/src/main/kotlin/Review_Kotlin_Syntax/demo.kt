import kotlin.random.Random

fun main(args: Array<String>) {
    //Khai bao bien
    var soA:Int = 5;
    var soA2 = 6;
    var soB:Double = 9.5;
    var soC:Long = 999L;
    var soD:Float = 22.5f;
    //in ra
    println("Gia tri cua A: " +soA);
    println("Gia tri cua A: $soA");

    //Kt kieu du lieu
    println("Kiểu dữ liệu của B: "+ (soB::class.java.typeName));

    //Khai bao mảng:
    var mangSoNguyen:IntArray =  intArrayOf(1,2,3,4);
    var mangSoThuc:FloatArray = floatArrayOf(2.5f,2.4f,2.8f);
    var mangKyTu:CharArray = charArrayOf('a','b','c');

    println("Mảng số nguyên: ${mangSoNguyen[0]}");

    //Khai báo hằng số
    val COLOR_OF_BACKGROUND = "RED";

    //Ép kiểu:  Int -> Long -> Float -> Double
    var soBEpKieu:Double = soA.toDouble();
    println("So B:  $soBEpKieu,  Kieu du lieu: "+(soBEpKieu::class.java.typeName));

    //Phép gán: như các ngôn ngữ khác
    //Các  hàm so sánh
    println(soA.equals(soA2));
    println(soA.compareTo(soA2));

    //logic: && ,||
    //prefix, postfix: ++. --

    //Ép kiểu dữ liệu cho chuỗi
    var a1:Boolean = "true".toBoolean();
    //tương tự cho các kiểu dữ liệu còn lại (short, byte,..)

    //Nhập chuỗi từ bàn phím người dùng
    println("Mời cụ nhập vào tên: ");
    var ten:String?= readln()
    println("Tên cụ vừa nhập là: $ten");

    //Nhập số
    println("Nhập số đi cụ: ")
    var so:Int;
    var string1:String?= readln();
    if (string1 != null) {
        so  = string1.toInt()
    };
    println("Số cụ vừa nhập là :$string1");

    //if else thông thường
    var a:Int = 15;
    var b:Int =16;
    var max:Int;
    max  = if(a>b) a else b;
    println("max là: "+max);

    //thử làm 1 bài


    println("Mời bạn nhập tổng 2 số: ")
    var tong2So:Float?= readln().toFloat();
    println("Mời bạn nhập hiệu 2 số: ")
    var hieu2So:Float?= readln().toFloat();

    println("Bạn nhập tổng 2 số là: $tong2So");
    println("Bạn nhập hiệu 2 số là: $hieu2So");

    if (tong2So != null) {
        println("Giá trị x cần tìm: "+ (tong2So + hieu2So!!)/2);
    };

    //when: như bao ngôn ngữ khác, có điều kiện đâầu vào , syntax hơi khác chút xíu ví dụ:
//    when(i){
//        i->println();
//        else -> println();
//    }

    //for loop: cũng giống bao ngôn ngữ khác
    for(i in 1..9 step 2){
        print(i);
    }
    //còn kiểu for nữa thì gioongs forEach trong js, java, na ná java

    //do while: cũng giống như bao ngôn ngữ, chắc chắn chạy 1 vòng lần đầu

    //break: thoát khỏi 1 vòng lặp
    // continue: bỏ qua 1 giá trị trong 1 vòng lặp

    //xử lý ngoại lệ, lỗi : try catch thông thường, option finally
    //throw Exception: lỗi này mình dự đoán được trước, mình custom output để người dùng b iết
    //Datetime: thư viện, cần thì search gg

    //random:
    var rd = Random;
    var rdInt = rd.nextInt(10);
    println("random int: , $rdInt");

    //xử lý String, char: như thông thường

    //Array cũng vậy, chủ yếu syntax chứ ko khác mấy java
    //oop, kế thừa đa hình trừu tượng đóng gói cũng không khác mấy, chỉ syntax xíu
}