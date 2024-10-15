package com.example.trabajo13.Modal

class Imc (
    val peso: String = "",
    val alto: String = "",
    val edad: String = "",
    val imcResult: Float = 0f
){
    fun copy(
        peso: String = this.peso,
        alto: String = this.alto,
        edad: String = this.edad,
        imcResult: Float = this.imcResult
    ):Imc{
        return Imc(peso, alto, edad, imcResult)
    }

}