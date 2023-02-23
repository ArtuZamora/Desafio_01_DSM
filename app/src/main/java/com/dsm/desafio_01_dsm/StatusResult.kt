package com.dsm.desafio_01_dsm

import java.util.ArrayList

class StatusResult {
    var success: Boolean
    var errors: ArrayList<String>

    constructor(success: Boolean, errors: ArrayList<String> = ArrayList<String>()){
        this.success = success
        this.errors = errors
    }
}