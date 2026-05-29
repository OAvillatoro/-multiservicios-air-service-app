package com.multiserviciosoriente.airserviceapp.presentation.screens.profile

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
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.multiserviciosoriente.airserviceapp.R

@Composable
fun ClientProfileScreen(
    onBackClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("Juan Pérez") }
    var username by remember { mutableStateOf("juanperez") }
    var email by remember { mutableStateOf("juan.perez@email.com") }
    var phone by remember { mutableStateOf("7123-4567") }
    var address by remember { mutableStateOf("Col. San Antonio, San Miguel") }
    var referencePoint by remember { mutableStateOf("Casa color blanco, cerca del parque") }

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
                    text = "Mi perfil",
                    color = Color.White,
                    fontSize = 27.sp,
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
                    modifier = Modifier.size(145.dp)
                )

                Text(
                    text = "Datos del cliente",
                    color = primaryBlue,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Consulta y actualiza la información asociada a tu cuenta de cliente.",
                    color = Color.Gray,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 23.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

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
                            text = "👤",
                            fontSize = 32.sp
                        )

                        Column(
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            Text(
                                text = "Cuenta de cliente",
                                color = primaryBlue,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Estos datos se utilizan para registrar tus solicitudes, ubicar tus equipos y coordinar visitas técnicas.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp,
                                lineHeight = 19.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                ProfileTextField(
                    label = "Nombre completo *",
                    value = fullName,
                    placeholder = "Ingresa tu nombre completo",
                    onValueChange = { fullName = it },
                    keyboardType = KeyboardType.Text
                )

                ProfileTextField(
                    label = "Nombre de usuario *",
                    value = username,
                    placeholder = "Elige un nombre de usuario",
                    onValueChange = { username = it },
                    keyboardType = KeyboardType.Text
                )

                ProfileTextField(
                    label = "Correo electrónico *",
                    value = email,
                    placeholder = "ejemplo@correo.com",
                    onValueChange = { email = it },
                    keyboardType = KeyboardType.Email
                )

                ProfileTextField(
                    label = "Teléfono *",
                    value = phone,
                    placeholder = "Ingresa tu número de teléfono",
                    onValueChange = { phone = it },
                    keyboardType = KeyboardType.Phone
                )

                ProfileTextField(
                    label = "Dirección *",
                    value = address,
                    placeholder = "Ingresa tu dirección completa",
                    onValueChange = { address = it },
                    keyboardType = KeyboardType.Text
                )

                ProfileTextField(
                    label = "Punto de referencia",
                    value = referencePoint,
                    placeholder = "Ej. Casa color blanco cerca del parque",
                    onValueChange = { referencePoint = it },
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(12.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFFFF7E8),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ℹ️",
                            fontSize = 30.sp
                        )

                        Column(
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            Text(
                                text = "Información importante",
                                color = orange,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Más adelante estos datos se guardarán en la tabla users mediante Room. Por ahora se usan datos de prueba para validar el diseño y la navegación.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp,
                                lineHeight = 19.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "VOLVER",
                            color = primaryBlue,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = onBackClick,
                        modifier = Modifier
                            .weight(1.4f)
                            .height(58.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryBlue
                        )
                    ) {
                        Text(
                            text = "GUARDAR CAMBIOS",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f))

                    Text(
                        text = "  Perfil del cliente  ",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Divider(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Rol: Cliente",
                    color = textColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Estado: Cuenta activa",
                    color = Color(0xFF00865A),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

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
private fun ProfileTextField(
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType
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