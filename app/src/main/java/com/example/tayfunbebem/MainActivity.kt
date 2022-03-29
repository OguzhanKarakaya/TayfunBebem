package com.example.tayfunbebem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tayfunbebem.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var clothesList = ArrayList<ClothesModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getDBObjects()
    }


    private fun getDBObjects() {
        try {
            clothesList = ArrayList()
            val obj = JSONObject(loadJSONFromAsset())
            val clothesJsonArray =
                obj.getJSONArray("TEST_LIST_DATABASE")

            clothesList = Gson().fromJson(
                clothesJsonArray.toString(),
                object : TypeToken<List<ClothesModel?>?>() {}.type
            )

            val clothesAdapter = ClothesAdapter(clothesList)
            binding.recycler.layoutManager = LinearLayoutManager(this)
            binding.recycler.adapter = clothesAdapter

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val inputStream = assets.open("test_list.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}