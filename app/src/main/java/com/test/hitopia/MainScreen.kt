package com.test.hitopia

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.hitopia.function.BalancedBracket
import com.test.hitopia.function.HighestPalindrome
import com.test.hitopia.function.WeightedString
import com.test.hitopia.ui.theme.HitopiaTestTheme

@Composable
fun MainScreen() {

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                WeightedStringSection()
                Spacer(modifier = Modifier.height(16.dp))
                BalancedBracketSection()
                Spacer(modifier = Modifier.height(16.dp))
                HighestPalindromeSection()
            }
        }
    )
}

@Composable
private fun WeightedStringSection() {

    val weightedStringInput = rememberSaveable {
        mutableStateOf("")
    }

    val weightedStringQueries = rememberSaveable {
        mutableStateOf("")
    }

    val weightedStringResult = rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column {
        Text(text = "Weighted Strings")
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = {
                    Text(text = "String abcd")
                },
                value = weightedStringInput.value,
                onValueChange = { value ->
                    weightedStringInput.value = value
                }
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = {
                    Text(text = "Queries (1, 3, 9, 8)")
                },
                value = weightedStringQueries.value,
                onValueChange = { value ->
                    weightedStringQueries.value = value
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                try {
                    val weightedString = WeightedString()
                    val queries = weightedStringQueries.value.replace(" ", "").split(",").toList()
                    val result = weightedString.getResult(
                        weightedStringInput.value,
                        queries.map { value -> value.toInt() }
                    )
                    weightedStringResult.value = result.toString()
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Submit")
        }
        if (weightedStringResult.value.isNotEmpty()) {
            Text(text = weightedStringResult.value)
        }
    }
}

@Composable
private fun BalancedBracketSection() {

    val balancedBracketInput = rememberSaveable {
        mutableStateOf("")
    }

    val balancedBracketResult = rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column {
        Text(text = "Balanced Bracket")
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = {
                    Text(text = "Brackets")
                },
                value = balancedBracketInput.value,
                onValueChange = { value ->
                    balancedBracketInput.value = value
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                try {
                    val balancedBracket = BalancedBracket()
                    val result = balancedBracket.getResult(
                        balancedBracketInput.value
                    )
                    balancedBracketResult.value = result
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Submit")
        }
        if (balancedBracketResult.value.isNotEmpty()) {
            Text(text = balancedBracketResult.value)
        }
    }
}

@Composable
private fun HighestPalindromeSection() {

    val highestPalindromeInput = rememberSaveable {
        mutableStateOf("")
    }

    val highestPalindromeK = rememberSaveable {
        mutableStateOf("")
    }

    val highestPalindromeResult = rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column {
        Text(text = "HighestPalindrome")
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = {
                    Text(text = "Number")
                },
                value = highestPalindromeInput.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { value ->
                    highestPalindromeInput.value = value
                }
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = {
                    Text(text = "K digits")
                },
                value = highestPalindromeK.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { value ->
                    highestPalindromeK.value = value
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                try {
                    val highestPalindrome = HighestPalindrome()
                    val result = highestPalindrome.getResult(
                        highestPalindromeInput.value,
                        highestPalindromeK.value.toInt()
                    )
                    highestPalindromeResult.value = result
                } catch (e: Exception) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Submit")
        }
        if (highestPalindromeResult.value.isNotEmpty()) {
            Text(text = highestPalindromeResult.value)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    HitopiaTestTheme {
        MainScreen()
    }
}