package com.example.kppniisby.Model

class DatabaseSpm {
    var SPM: String? = null
    var Status: String? = null
    var id: Double? = null
    lateinit var namasatker: String
    lateinit var tanggal: String

    constructor() {}
    constructor(SPM: String, Status: String, id: Double, namasatker: String, tanggal: String) {
        this.SPM = SPM
        this.Status = Status
        this.id = id
        this.namasatker = namasatker
        this.tanggal = tanggal
    }

}