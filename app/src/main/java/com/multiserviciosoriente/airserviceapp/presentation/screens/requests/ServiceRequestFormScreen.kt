package com.multiserviciosoriente.airserviceapp.presentation.screens.requests

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ServiceRequestFormScreen(
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit,
    isAdmin: Boolean = false
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val red = Color(0xFFE53935)
    val textDark = Color(0xFF17213D)

    var client by remember { mutableStateOf("Juan Pérez García") }
    var equipment by remember { mutableStateOf("Samsung WindFree 12,000 BTU - Sala principal") }
    var serviceType by remember { mutableStateOf("Preventivo") }
    var priority by remember { mutableStateOf("Baja") }
    var description by remember { mutableStateOf("") }
    var symptoms by remember { mutableStateOf("") }
    var preferredDate by remember { mutableStateOf("") }
    var preferredTime by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            RequestHeader(
                title = if (isAdmin) "Nueva solicitud administrativa" else "Nueva solicitud de servicio",
                subtitle = if (isAdmin) {
                    "Registra una solicitud en nombre de un cliente"
                } else {
                    "Completa la información para solicitar mantenimiento"
                },
                primaryBlue = primaryBlue,
                textDark = textDark,
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(18.dp))

            InfoBanner(
                title = "Importante",
                message = if (isAdmin) {
                    "Esta solicitud será registrada desde administración y podrá ser programada posteriormente."
                } else {
                    "Tu solicitud será atendida por nuestro equipo técnico. Te notificaremos sobre el estado de tu solicitud."
                },
                primaryBlue = primaryBlue
            )

            Spacer(modifier = Modifier.height(18.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    if (isAdmin) {
                        SectionTitle(
                            number = "1",
                            icon = "👤",
                            title = "Selecciona el cliente",
                            color = primaryBlue
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        AppRequestTextField(
                            label = "Cliente *",
                            value = client,
                            onValueChange = { client = it },
                            placeholder = "Ej. Juan Pérez García",
                            primaryBlue = primaryBlue
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Divider()

                        Spacer(modifier = Modifier.height(16.dp))

                        SectionTitle(
                            number = "2",
                            icon = "❄️",
                            title = "Selecciona el equipo",
                            color = primaryBlue
                        )
                    } else {
                        SectionTitle(
                            number = "1",
                            icon = "❄️",
                            title = "Selecciona el equipo",
                            color = primaryBlue
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    AppRequestTextField(
                        label = "Equipo *",
                        value = equipment,
                        onValueChange = { equipment = it },
                        placeholder = "Seleccione el equipo asociado",
                        primaryBlue = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = green.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "✅ Próximo mantenimiento preventivo: 15 oct. 2024",
                            color = green,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        number = if (isAdmin) "3" else "2",
                        icon = "🔧",
                        title = "Tipo de servicio",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Tipo de servicio *",
                        color = textDark,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ServiceTypeCard(
                            title = "Preventivo",
                            description = "Revisión y limpieza programada.",
                            icon = "📅",
                            selected = serviceType == "Preventivo",
                            color = primaryBlue,
                            modifier = Modifier.weight(1f),
                            onClick = { serviceType = "Preventivo" }
                        )

                        ServiceTypeCard(
                            title = "Correctivo",
                            description = "El equipo presenta fallas.",
                            icon = "🛠️",
                            selected = serviceType == "Correctivo",
                            color = red,
                            modifier = Modifier.weight(1f),
                            onClick = { serviceType = "Correctivo" }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    ServiceTypeCard(
                        title = "Instalación / Reinstalación",
                        description = "Instalación o reinstalación de equipo de aire acondicionado.",
                        icon = "🔩",
                        selected = serviceType == "Instalación",
                        color = orange,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { serviceType = "Instalación" }
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = "Prioridad *",
                        color = textDark,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PriorityCard(
                            title = "Baja",
                            description = "Puede esperar",
                            selected = priority == "Baja",
                            color = green,
                            modifier = Modifier.weight(1f),
                            onClick = { priority = "Baja" }
                        )

                        PriorityCard(
                            title = "Media",
                            description = "Próximos días",
                            selected = priority == "Media",
                            color = orange,
                            modifier = Modifier.weight(1f),
                            onClick = { priority = "Media" }
                        )

                        PriorityCard(
                            title = "Alta",
                            description = "Urgente",
                            selected = priority == "Alta",
                            color = red,
                            modifier = Modifier.weight(1f),
                            onClick = { priority = "Alta" }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        number = if (isAdmin) "4" else "3",
                        icon = "📄",
                        title = "Detalle del servicio",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    AppRequestTextField(
                        label = "Descripción del problema o servicio solicitado *",
                        value = description,
                        onValueChange = { description = it },
                        placeholder = "Describe en detalle el problema o servicio que necesitas...",
                        primaryBlue = primaryBlue,
                        minLines = 4
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AppRequestTextField(
                        label = "Síntomas o detalles adicionales",
                        value = symptoms,
                        onValueChange = { symptoms = it },
                        placeholder = "Agrega información adicional que pueda ser útil...",
                        primaryBlue = primaryBlue,
                        minLines = 3
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        number = if (isAdmin) "5" else "4",
                        icon = "📍",
                        title = "Información adicional",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AppRequestTextField(
                            label = "Fecha preferida",
                            value = preferredDate,
                            onValueChange = { preferredDate = it },
                            placeholder = "Ej. 20/10/2024",
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )

                        AppRequestTextField(
                            label = "Horario preferido",
                            value = preferredTime,
                            onValueChange = { preferredTime = it },
                            placeholder = "Ej. 9:00 a. m.",
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    AppRequestTextField(
                        label = "Notas adicionales",
                        value = notes,
                        onValueChange = { notes = it },
                        placeholder = "Cualquier información adicional que consideres importante...",
                        primaryBlue = primaryBlue,
                        minLines = 3
                    )

                    if (isAdmin) {
                        Spacer(modifier = Modifier.height(14.dp))

                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color(0xFFFFF7E8),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "ℹ️ La solicitud quedará registrada para revisión, programación y asignación de técnico.",
                                color = Color(0xFF4B5878),
                                fontSize = 14.sp,
                                lineHeight = 19.sp,
                                modifier = Modifier.padding(14.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 8.dp),
            color = Color.White,
            shape = RoundedCornerShape(18.dp),
            shadowElevation = 6.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Cancelar",
                        color = primaryBlue,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = onSubmitClick,
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryBlue
                    )
                ) {
                    Text(
                        text = if (isAdmin) "Guardar solicitud" else "Enviar solicitud",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun RequestHeader(
    title: String,
    subtitle: String,
    primaryBlue: Color,
    textDark: Color,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "‹",
            color = primaryBlue,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onBackClick() }
        )

        Column(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = title,
                color = textDark,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = subtitle,
                color = Color(0xFF5D6678),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box {
            Text(
                text = "🔔",
                fontSize = 28.sp
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(19.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE53935)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun InfoBanner(
    title: String,
    message: String,
    primaryBlue: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFEAF2FF),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(primaryBlue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "i",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = title,
                    color = Color(0xFF17213D),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = message,
                    color = Color(0xFF4B5878),
                    fontSize = 14.sp,
                    lineHeight = 19.sp
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(
    number: String,
    icon: String,
    title: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "$number. $title",
            color = color,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ServiceTypeCard(
    title: String,
    description: String,
    icon: String,
    selected: Boolean,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(135.dp)
            .clickable { onClick() },
        color = if (selected) color.copy(alpha = 0.08f) else Color.White,
        shape = RoundedCornerShape(14.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = if (selected) 1.5.dp else 1.dp,
            color = if (selected) color else Color(0xFFD0D7E2)
        )
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (selected) "●" else "○",
                color = color,
                fontSize = 20.sp
            )

            Text(
                text = icon,
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = title,
                color = Color(0xFF17213D),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                color = Color(0xFF5D6678),
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
private fun PriorityCard(
    title: String,
    description: String,
    selected: Boolean,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(76.dp)
            .clickable { onClick() },
        color = if (selected) color.copy(alpha = 0.08f) else Color.White,
        shape = RoundedCornerShape(14.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = if (selected) 1.5.dp else 1.dp,
            color = if (selected) color else Color(0xFFD0D7E2)
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "● $title",
                color = color,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = description,
                color = Color(0xFF5D6678),
                fontSize = 11.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun AppRequestTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    primaryBlue: Color,
    modifier: Modifier = Modifier,
    minLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            color = Color(0xFF17213D),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFF8A93A6),
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            minLines = minLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryBlue,
                unfocusedBorderColor = Color(0xFFD0D7E2),
                cursorColor = primaryBlue,
                focusedTextColor = Color(0xFF17213D),
                unfocusedTextColor = Color(0xFF17213D),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}