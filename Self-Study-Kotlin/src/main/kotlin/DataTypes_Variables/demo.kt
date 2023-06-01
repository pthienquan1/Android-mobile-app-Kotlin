fun main(args: Array<String>) {
    //Khai bao bien
    var soA:Int = 5;
    var soA2 = 5;
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

}