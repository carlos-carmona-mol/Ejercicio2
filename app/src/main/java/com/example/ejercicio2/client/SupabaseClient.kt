package com.example.ejercicio2.client

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://qooqqfugtfejsvfzlbro.supabase.co",
        supabaseKey = "sb_publishable_7ozZrMOHoGXLhsFvdneSFA_4fT4As1y"
    ){
        install(Postgrest)
    }
}