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
        /*return  nombre.length in 1..20 && nombre.matches("-?[0-9]+(\\\\.[0-9]+)?".toRegex())*/
        /*return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }*/

        println("Escriba el apellido:")
        var apellido= readln()
        while (!validarApellido(apellido)){
            println("Apellido invalido ingrese uno valido")
            apellido= readln()
        }


        println("Ingrese su edad")
        var edad= readln().toInt()
        while (!validarEdad(edad)){
            println("Edad invalida ingrese una edad correcta")
            edad= readln().toInt()
        }


        println("Ingrese su correo")
        var correo= readln()
        while (!validarCorreo(correo)){
            println("Correo invalido intente nuevamente")
            correo= readln()
        }


        println("Ingrese su sistema de salud")
        var sistemaSalud= readln()
        while (!validarSistemaDeSalud(sistemaSalud)){
            println("Sistema de salud incorrecto intente nuevamente")
            sistemaSalud= readln()
        }

        var usuario= Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)

    }
    for (u in usuarios.sortedBy {
        usuario -> usuario.edad
    }){
        println("$u")
    }

}
fun validarNombre(nombre: String): Boolean{
     return nombre.length in 1..20

}
fun validarApellido(apellido: String): Boolean{
    return apellido.length in 1..20

}
fun validarEdad(edad: Int): Boolean{
    return edad in 1..150

}
fun validarCorreo(correo: String): Boolean{
    return correo.length in (10..200) && correo.contains('@')

}
fun validarSistemaDeSalud(sistemaSalud: String): Boolean{
    return sistemaSalud=="Fonasa"|| sistemaSalud=="Isapre"||sistemaSalud=="fonada"||sistemaSalud=="isapre"

}

 data class Usuario(val nombre:String, val apellido:String,val edad:Int, val correo:String, val sistemaSalud:String)