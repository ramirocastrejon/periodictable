package com.ramiroc.periodictable.data.model

data class Element(
    val atomicNumber: String?,
    val symbol: String?,
    val name: String?,

    val electronicConfiguration: String?,
    val electronegativity: String?,
    val atomicRadius: String?,
    val ionRadius: String?,
    val vanDerWaalsRadius: String?,
    val ionizationEnergy: String?,
    val electronAffinity: String?,
    val oxidationStates: String?,
    val standardState: String?,
    val bondingType: String?,
    val meltingPoint: String,
    val boilingPoint: String,
    val density: String?,
    val groupBlock: String?,
    val yearDiscovered: String?,
    val block: String?,
    val cpkHexColor: String?,
    val period: String?,
    val group: String?
)
