package io.devexpert.proyectoaceros.Model

data class UpEmpleados (
    val NumEmpleado : Long,
    val Correo : String,
    val Password_hash : String,
    val Salt : String,
    val Estado : Long
)