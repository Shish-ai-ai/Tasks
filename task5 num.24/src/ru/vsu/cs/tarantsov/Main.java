package ru.vsu.cs.tarantsov;


public class Main {

    public static void main(String[] args) {
        String text = "На дворе играла кошка с котятами Вдруг с вышины бросился огромный орёл. Орёл схватил котенка. Мать кошка быстро вцепилась в орла. Орёл бросил котенка и стал пороться с кошкой. Он рвал когтя-га тело кошки и выклевал ей один лаз. Кошка храбро боролась с орлом. Она перекусила ему крыло. Потом кошка сделала ловкий прыжок и перекусила орлу горло.";
        String[] arr = text.split(" ");
        BinaryTree tree = new BinaryTree();
        for (String i: arr) {
            tree.insertNode(i);
        }
        System.out.println(tree.findByValue("с"));

    }
}
