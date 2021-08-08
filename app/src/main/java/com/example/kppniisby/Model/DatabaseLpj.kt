package com.example.kppniisby.Model

class DatabaseLpj {
    var BAKR: String? = null
    var Date: String? = null
    var KSS: String? = null
    var LPJKeluar: String? = null
    var LPJTerima: String? = null
    var RK: String? = null
    var SRB: String? = null
    var id: Double? = null
    lateinit var namasatker: String

    constructor() {}
    constructor(BAKR: String, Date: String, KSS: String, LPJKeluar: String, LPJTerima: String,
                RK: String, SRB: String, id: Double, namasatker: String) {
        this.BAKR = BAKR
        this.Date = Date
        this.KSS = KSS
        this.LPJKeluar = LPJKeluar
        this.LPJTerima = LPJTerima
        this.RK = RK
        this.SRB = SRB
        this.id = id
        this.namasatker = namasatker
    }

}