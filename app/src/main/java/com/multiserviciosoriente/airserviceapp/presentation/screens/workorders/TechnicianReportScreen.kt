package com.multiserviciosoriente.airserviceapp.presentation.screens.workorders

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TechnicianReportScreen(
    onBackClick: () -> Unit
) {
    val primaryBlue = Color(0xFF0047C7)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF6F00)
    val green = Color(0xFF1B8F3A)
    val textDark = Color(0xFF17213D)

    var clientAbsent by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        TechnicianReportTopBar(
            darkBlue = darkBlue,
            primaryBlue = primaryBlue,
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Inicio  ›  Órdenes de trabajo  ›  OT-2024-0128  ›  Reporte final",
                color = Color(0xFF4B5878),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(primaryBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "📋",
                                fontSize = 26.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Reporte final del servicio",
                                color = textDark,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Registra los detalles del trabajo realizado y finaliza el servicio.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "?  Ayuda",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    ReportSummaryCard(
                        primaryBlue = primaryBlue,
                        orange = orange,
                        green = green
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    ReportTextSection(
                        title = "Detalle del trabajo realizado",
                        subtitle = "Describe las actividades realizadas durante la visita técnica.",
                        icon = "📄",
                        value = "Se revisó el equipo completo. Se encontró falla en el capacitor del compresor, el cual se reemplazó.\n\nSe realizó limpieza de filtros, serpentín y bandeja de drenaje.\n\nSe verificó nivel de gas refrigerante y presiones operativas.\n\nEl equipo queda funcionando correctamente.",
                        counter = "235/1000",
                        primaryBlue = primaryBlue,
                        required = true
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    ReportTextSection(
                        title = "Recomendaciones",
                        subtitle = "Indica recomendaciones al cliente para el buen funcionamiento del equipo.",
                        icon = "💬",
                        value = "Se recomienda realizar mantenimiento preventivo cada 6 meses.\n\nMantener filtros limpios y evitar obstrucciones en las entradas y salidas de aire.",
                        counter = "146/1000",
                        primaryBlue = primaryBlue,
                        required = false
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            Column(
                                modifier = Modifier.weight(0.8f)
                            ) {
                                SectionTitle(
                                    icon = "👤",
                                    title = "Cliente ausente",
                                    primaryBlue = primaryBlue
                                )

                                Spacer(modifier = Modifier.height(14.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = !clientAbsent,
                                        onClick = { clientAbsent = false },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = primaryBlue
                                        )
                                    )

                                    Text(
                                        text = "No",
                                        color = textDark,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Medium
                                    )

                                    Spacer(modifier = Modifier.width(24.dp))

                                    RadioButton(
                                        selected = clientAbsent,
                                        onClick = { clientAbsent = true },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = primaryBlue
                                        )
                                    )

                                    Text(
                                        text = "Sí",
                                        color = textDark,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }

                            Divider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(110.dp),
                                color = Color(0xFFE1E6F0)
                            )

                            Column(
                                modifier = Modifier.weight(1.4f)
                            ) {
                                Text(
                                    text = "Observación (solo si el cliente estuvo ausente)",
                                    color = textDark,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                FakeInputBox(
                                    text = if (clientAbsent) {
                                        "Cliente no se encontraba en la dirección al momento de la visita."
                                    } else {
                                        "Explica la situación encontrada en la visita..."
                                    },
                                    counter = "0/500",
                                    minHeight = 84.dp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            SectionTitle(
                                icon = "💵",
                                title = "Monto sugerido",
                                primaryBlue = primaryBlue
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(18.dp)
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "Monto sugerido (USD) *",
                                        color = textDark,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    FakeInputBox(
                                        text = "$   95.00",
                                        minHeight = 54.dp
                                    )
                                }

                                Column(
                                    modifier = Modifier.weight(1.7f)
                                ) {
                                    Text(
                                        text = "Incluye",
                                        color = textDark,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    FakeInputBox(
                                        text = "Repuesto (capacitor), limpieza general y revisión completa del sistema.",
                                        minHeight = 54.dp
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFEAF2FF),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(primaryBlue),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "i",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = "Información",
                                    color = primaryBlue,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Al finalizar el servicio, el reporte quedará registrado y la orden de trabajo podrá ser revisada por el administrador.\nAsegúrate de completar correctamente todos los campos antes de finalizar.",
                                    color = Color(0xFF31415F),
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedButton(
                            onClick = onBackClick,
                            modifier = Modifier
                                .weight(1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "⊗  Cancelar",
                                color = darkBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = onBackClick,
                            modifier = Modifier
                                .weight(1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryBlue
                            )
                        ) {
                            Text(
                                text = "✓  Finalizar servicio",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun TechnicianReportTopBar(
    darkBlue: Color,
    primaryBlue: Color,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(darkBlue, primaryBlue)
                )
            )
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "☰",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = "MultiServicios\nOriente",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.width(18.dp))

            Divider(
                modifier = Modifier
                    .height(42.dp)
                    .width(1.dp),
                color = Color.White.copy(alpha = 0.35f)
            )

            Spacer(modifier = Modifier.width(22.dp))

            Text(
                text = "Mis Órdenes de Trabajo",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "🔎",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box {
                Text(
                    text = "🔔",
                    fontSize = 25.sp
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF3D00)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "5",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEAF2FF)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "👤",
                    fontSize = 23.sp
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "Carlos Méndez",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Técnico HVAC",
                    color = Color.White.copy(alpha = 0.88f),
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
private fun ReportSummaryCard(
    primaryBlue: Color,
    orange: Color,
    green: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
    ) {
        Column {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SummaryBlock(
                    label = "Orden de trabajo",
                    title = "#OT-2024-0128",
                    subtitle = "●  En proceso",
                    subtitleColor = green,
                    modifier = Modifier.weight(1f)
                )

                SummaryBlock(
                    label = "Cliente",
                    title = "María López Torres",
                    subtitle = "7123-4567",
                    modifier = Modifier.weight(1f)
                )

                SummaryBlock(
                    label = "Equipo",
                    title = "LG Dual Inverter\n18,000 BTU",
                    subtitle = "SN: LG18DI2023B009874",
                    modifier = Modifier.weight(1f)
                )

                SummaryBlock(
                    label = "Tipo de mantenimiento",
                    title = "🛠",
                    subtitle = "Mantenimiento correctivo",
                    subtitleColor = orange,
                    modifier = Modifier.weight(1f)
                )
            }

            Divider(color = Color(0xFFE1E6F0))

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SummaryBlock(
                    label = "Fecha y hora programada",
                    title = "21/05/2024     09:30 AM",
                    subtitle = "",
                    modifier = Modifier.weight(1f)
                )

                SummaryBlock(
                    label = "Técnico asignado",
                    title = "Carlos Méndez",
                    subtitle = "Técnico HVAC",
                    modifier = Modifier.weight(1f)
                )

                SummaryBlock(
                    label = "Dirección",
                    title = "Col. San Antonio, San Miguel",
                    subtitle = "Sala principal",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SummaryBlock(
    label: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    subtitleColor: Color = Color(0xFF4B5878)
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            color = Color(0xFF17213D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = title,
            color = Color(0xFF003F99),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 21.sp
        )

        if (subtitle.isNotBlank()) {
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = subtitle,
                color = subtitleColor,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = if (subtitleColor != Color(0xFF4B5878)) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

@Composable
private fun ReportTextSection(
    title: String,
    subtitle: String,
    icon: String,
    value: String,
    counter: String,
    primaryBlue: Color,
    required: Boolean
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            SectionTitle(
                icon = icon,
                title = if (required) "$title *" else title,
                primaryBlue = primaryBlue
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = subtitle,
                color = Color(0xFF4B5878),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            FakeInputBox(
                text = value,
                counter = counter,
                minHeight = 150.dp
            )
        }
    }
}

@Composable
private fun SectionTitle(
    icon: String,
    title: String,
    primaryBlue: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(primaryBlue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = title,
            color = primaryBlue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun FakeInputBox(
    text: String,
    counter: String? = null,
    minHeight: androidx.compose.ui.unit.Dp
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(minHeight),
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFD6DCE8))
    ) {
        Box(
            modifier = Modifier.padding(14.dp)
        ) {
            Text(
                text = text,
                color = Color(0xFF4B5878),
                fontSize = 14.sp,
                lineHeight = 22.sp
            )

            if (counter != null) {
                Text(
                    text = counter,
                    color = Color(0xFF4B5878),
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}