package com.example.docekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
    var usuarios = mutableListOf<Usuario>()
    println("Ingrese la cantidad de usuarios")
    val cantidadUsuario = readln(). toInt()
    for (i in 1..cantidadUsuario){

        println("Ingrese el nombre:")
        var nombre= readln()
        while (!validarNombre(nombre)){
            println("Nombre invalido ingrese un nombre valido")
            nombre= readln()
        }

        println("Escriba el apellido:")
        var apellido= readln()


        println("Ingrese su edad")
        var edad= readln().toInt()


        println("Ingrese su correo")
        var correo= readln()

        
        println("Ingrese su sistema de salud")
        var sistemaSalud= readln()

        var usuario= Usuario(nombre, apellido, edad, correo, sistemaSalud)

        usuarios.add(usuario)

    }
    for (u in usuarios){
        println(u)
    }

}
fun validarNombre(nombre: String): Boolean{
     return nombre.length in 1..20

}
 data class Usuario(var nombre:String, var apellido:String,var edad:Int, var correo:String, var sistemaSalud:String)