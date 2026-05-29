package com.multiserviciosoriente.airserviceapp.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.multiserviciosoriente.airserviceapp.R

@Composable
fun RegisterClientScreen(
    onBackClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var referencePoint by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var acceptedTerms by remember { mutableStateOf(false) }

    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val textColor = Color(0xFF17213D)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                darkBlue,
                                primaryBlue
                            )
                        )
                    )
            ) {
                TextButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 18.dp)
                ) {
                    Text(
                        text = "‹",
                        color = Color.White,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                Text(
                    text = "Crear cuenta de cliente",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(18.dp))

                Image(
                    painter = painterResource(id = R.drawable.logo_multiservicios_oriente),
                    contentDescription = "Logo MultiServicios de Oriente",
                    modifier = Modifier.size(155.dp)
                )

                Text(
                    text = "¡Crea tu cuenta!",
                    color = primaryBlue,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Completa la información para registrarte y comenzar a usar la aplicación.",
                    color = Color.Gray,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 23.sp
                )

                Spacer(modifier = Modifier.height(26.dp))

                RegisterTextField(
                    label = "Nombre completo *",
                    value = fullName,
                    placeholder = "Ingresa tu nombre completo",
                    onValueChange = { fullName = it },
                    keyboardType = KeyboardType.Text
                )

                RegisterTextField(
                    label = "Nombre de usuario *",
                    value = username,
                    placeholder = "Elige un nombre de usuario",
                    onValueChange = { username = it },
                    keyboardType = KeyboardType.Text
                )

                RegisterTextField(
                    label = "Correo electrónico *",
                    value = email,
                    placeholder = "ejemplo@correo.com",
                    onValueChange = { email = it },
                    keyboardType = KeyboardType.Email
                )

                RegisterTextField(
                    label = "Teléfono *",
                    value = phone,
                    placeholder = "Ingresa tu número de teléfono",
                    onValueChange = { phone = it },
                    keyboardType = KeyboardType.Phone
                )

                RegisterTextField(
                    label = "Dirección *",
                    value = address,
                    placeholder = "Ingresa tu dirección completa",
                    onValueChange = { address = it },
                    keyboardType = KeyboardType.Text
                )

                RegisterTextField(
                    label = "Punto de referencia (opcional)",
                    value = referencePoint,
                    placeholder = "Ej. Casa color blanco cerca del parque",
                    onValueChange = { referencePoint = it },
                    keyboardType = KeyboardType.Text
                )

                RegisterTextField(
                    label = "Contraseña *",
                    value = password,
                    placeholder = "Crea una contraseña segura",
                    onValueChange = { password = it },
                    keyboardType = KeyboardType.Password,
                    isPassword = true
                )

                RegisterTextField(
                    label = "Confirmar contraseña *",
                    value = confirmPassword,
                    placeholder = "Vuelve a escribir tu contraseña",
                    onValueChange = { confirmPassword = it },
                    keyboardType = KeyboardType.Password,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFEAF2FF),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🛡",
                            fontSize = 32.sp
                        )

                        Column(
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            Text(
                                text = "Tu información está segura",
                                color = primaryBlue,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Protegemos tus datos personales y solo serán utilizados para la gestión de servicios de mantenimiento.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp,
                                lineHeight = 19.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Checkbox(
                        checked = acceptedTerms,
                        onCheckedChange = { acceptedTerms = it }
                    )

                    Text(
                        text = "He leído y acepto los Términos y Condiciones y la Política de Privacidad *",
                        color = textColor,
                        fontSize = 15.sp,
                        lineHeight = 21.sp,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryBlue
                    )
                ) {
                    Text(
                        text = "CREAR CUENTA",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(
                        text = "  ¿Ya tienes una cuenta?  ",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Divider(modifier = Modifier.weight(1f))
                }

                TextButton(onClick = onBackClick) {
                    Text(
                        text = "Iniciar sesión",
                        color = primaryBlue,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .background(orange)
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun RegisterTextField(
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    isPassword: Boolean = false
) {
    val primaryBlue = Color(0xFF003F99)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp)
    ) {
        Text(
            text = label,
            color = primaryBlue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.Gray
                )
            },
            singleLine = true,
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                androidx.compose.ui.text.input.VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryBlue,
                focusedLabelColor = primaryBlue,
                cursorColor = primaryBlue
            )
        )
    }
}