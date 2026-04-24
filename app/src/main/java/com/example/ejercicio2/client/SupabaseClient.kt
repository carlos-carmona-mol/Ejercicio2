package com.example.ejercicio2.client

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://qooqqfugtfejsvfzlbro.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InFvb3FxZnVndGZlanN2ZnpsYnJvIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzY4NDM2NDYsImV4cCI6MjA5MjQxOTY0Nn0.yfFs1LOJ64dNMc_hEisa89KRUHT99TKobeKvHAO3dQY"
    ){
        install(Postgrest)
    }
}