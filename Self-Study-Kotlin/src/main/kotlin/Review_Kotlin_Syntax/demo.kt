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
}