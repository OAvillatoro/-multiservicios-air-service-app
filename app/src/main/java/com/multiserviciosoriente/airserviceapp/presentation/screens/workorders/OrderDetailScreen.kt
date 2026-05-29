package com.multiserviciosoriente.airserviceapp.presentation.screens.workorders

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderDetailScreen(
    onBackClick: () -> Unit,
    onReportClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val red = Color(0xFFE53935)
    val textDark = Color(0xFF17213D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        DetailTopBar(
            primaryBlue = primaryBlue,
            darkBlue = darkBlue,
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
                text = "Inicio  ›  Solicitudes  ›  Bandeja de solicitudes  ›  Detalle de solicitud / orden",
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
                        OutlinedButton(
                            onClick = onBackClick,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "‹",
                                color = primaryBlue,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Detalle de Solicitud / Orden",
                                color = textDark,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Consulta la información completa y el seguimiento de la solicitud de mantenimiento.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = {},
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "🖨 Imprimir",
                                    color = primaryBlue,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            OutlinedButton(
                                onClick = {},
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "✎ Editar",
                                    color = primaryBlue,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    SummaryCard(
                        primaryBlue = primaryBlue,
                        orange = orange,
                        green = green
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        ClientDataCard(
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )

                        EquipmentDataCard(
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    SectionCard(
                        title = "Descripción de la solicitud",
                        icon = "📄",
                        primaryBlue = primaryBlue
                    ) {
                        Text(
                            text = "El equipo no enfría correctamente y hace un ruido extraño al encender.",
                            color = Color(0xFF17213D),
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        RequestInfoCard(
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )

                        ScheduleInfoCard(
                            primaryBlue = primaryBlue,
                            orange = orange,
                            modifier = Modifier.weight(1f)
                        )

                        ExtraInfoCard(
                            primaryBlue = primaryBlue,
                            green = green,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    DetailTabs(primaryBlue = primaryBlue)

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        EventsHistoryCard(
                            primaryBlue = primaryBlue,
                            green = green,
                            orange = orange,
                            modifier = Modifier.weight(1f)
                        )

                        ReschedulesCard(
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )
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
                                text = "← Volver",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, red)
                        ) {
                            Text(
                                text = "🗑 Cancelar orden",
                                color = red,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = onReportClick,
                            modifier = Modifier
                                .weight(1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryBlue
                            )
                        ) {
                            Text(
                                text = "✓ Registrar reporte",
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
private fun DetailTopBar(
    primaryBlue: Color,
    darkBlue: Color,
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
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "☰",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "MultiServicios de Oriente",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Panel de Administración",
                    color = Color.White.copy(alpha = 0.88f),
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "🔎",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(12.dp))

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
                        .background(Color(0xFFE53935)),
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
        }
    }
}

@Composable
private fun SummaryCard(
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
                SummaryItem(
                    title = "ID Solicitud / Orden",
                    value = "#OT-2024-0128",
                    badge = "Orden de trabajo",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f)
                )

                SummaryItem(
                    title = "Tipo de mantenimiento",
                    value = "🛠 Mantenimiento correctivo",
                    badge = "",
                    color = orange,
                    modifier = Modifier.weight(1f)
                )

                SummaryItem(
                    title = "Estado actual",
                    value = "● En proceso",
                    badge = "",
                    color = green,
                    modifier = Modifier.weight(1f)
                )

                SummaryItem(
                    title = "Prioridad",
                    value = "⚑ Media",
                    badge = "",
                    color = orange,
                    modifier = Modifier.weight(1f)
                )
            }

            Divider(color = Color(0xFFE1E6F0))

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                InfoLine(
                    label = "Fecha y hora programada",
                    value = "📅 21/05/2024     🕘 09:30 AM",
                    modifier = Modifier.weight(1f)
                )

                InfoLine(
                    label = "Técnico asignado",
                    value = "👤 Carlos Méndez - Técnico HVAC     📞 7000-1111",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SummaryItem(
    title: String,
    value: String,
    badge: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Color(0xFF4B5878),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Surface(
            color = color.copy(alpha = 0.12f),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, color.copy(alpha = 0.35f))
        ) {
            Text(
                text = value,
                color = color,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }

        if (badge.isNotBlank()) {
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = badge,
                color = color,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ClientDataCard(
    primaryBlue: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Datos del cliente",
        icon = "👤",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoField("Nombre", "María López Torres", Modifier.weight(1f))
            InfoField("Teléfono", "7123-4567", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoField("Correo electrónico", "maria.lopez@gmail.com", Modifier.weight(1f))
            InfoField("Dirección", "Col. San Antonio, San Miguel", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(10.dp))

        InfoField("Punto de referencia", "Casa blanca frente al parque central")
    }
}

@Composable
private fun EquipmentDataCard(
    primaryBlue: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Datos del equipo",
        icon = "❄",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoField("Equipo", "LG Dual Inverter", Modifier.weight(1f))
            InfoField("Modelo", "18,000 BTU", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoField("Marca", "LG", Modifier.weight(1f))
            InfoField("Número de serie", "LG18DI2023B009874", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoField("Ubicación del equipo", "Sala principal", Modifier.weight(1f))
            InfoField("Fecha de instalación", "10/11/2022", Modifier.weight(1f))
        }
    }
}

@Composable
private fun RequestInfoCard(
    primaryBlue: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Información de la solicitud",
        icon = "📋",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        InfoField("Fecha de solicitud", "18/05/2024")
        Spacer(modifier = Modifier.height(10.dp))
        InfoField("Hora de solicitud", "02:00 PM")
        Spacer(modifier = Modifier.height(10.dp))
        InfoField("Solicitado por", "María López Torres\nCliente")
    }
}

@Composable
private fun ScheduleInfoCard(
    primaryBlue: Color,
    orange: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Programación del servicio",
        icon = "📅",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        InfoField("Fecha programada", "21/05/2024")
        Spacer(modifier = Modifier.height(10.dp))
        InfoField("Hora programada", "09:30 AM")
        Spacer(modifier = Modifier.height(10.dp))
        InfoField("Duración estimada", "1h 30m", accentColor = orange)
    }
}

@Composable
private fun ExtraInfoCard(
    primaryBlue: Color,
    green: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Información adicional",
        icon = "ℹ",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        InfoLine("Origen", "Teléfono")
        Spacer(modifier = Modifier.height(10.dp))
        InfoLine("Número de solicitud", "#SOL-2024-0057")
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Estado de la orden",
            color = Color(0xFF17213D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Solicitado  ━━  Programado  ━━  En proceso  ──  Completado",
            color = green,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun DetailTabs(
    primaryBlue: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TabItem("Historial de eventos", true, primaryBlue)
        TabItem("Reprogramaciones", false, primaryBlue)
        TabItem("Notas y comentarios", false, primaryBlue)
        TabItem("Archivos adjuntos", false, primaryBlue)
    }
}

@Composable
private fun TabItem(
    title: String,
    selected: Boolean,
    primaryBlue: Color
) {
    Surface(
        color = if (selected) primaryBlue.copy(alpha = 0.12f) else Color.White,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp,
            if (selected) primaryBlue else Color(0xFFE1E6F0)
        )
    ) {
        Text(
            text = title,
            color = if (selected) primaryBlue else Color(0xFF4B5878),
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        )
    }
}

@Composable
private fun EventsHistoryCard(
    primaryBlue: Color,
    green: Color,
    orange: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Historial de eventos",
        icon = "🕓",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        EventItem("18/05/2024\n02:00 PM", "Solicitud creada", "La solicitud de mantenimiento fue registrada por el cliente.", green)
        EventItem("18/05/2024\n03:15 PM", "Solicitud recibida", "La solicitud fue recibida y registrada en el sistema.", primaryBlue)
        EventItem("19/05/2024\n10:30 AM", "Programación asignada", "Se programó la visita para el 21/05/2024 a las 09:30 AM.", orange)
        EventItem("20/05/2024\n11:00 AM", "Técnico asignado", "Se asignó al técnico Carlos Méndez para la atención.", primaryBlue)
        EventItem("21/05/2024\n09:30 AM", "Servicio en proceso", "El técnico inició la atención de la orden de trabajo.", green)
    }
}

@Composable
private fun EventItem(
    date: String,
    title: String,
    description: String,
    color: Color
) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "•",
                color = color,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = date,
            color = Color(0xFF4B5878),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            modifier = Modifier.width(78.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                color = Color(0xFF17213D),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                color = Color(0xFF4B5878),
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
private fun ReschedulesCard(
    primaryBlue: Color,
    modifier: Modifier = Modifier
) {
    SectionCard(
        title = "Reprogramaciones realizadas",
        icon = "🕘",
        primaryBlue = primaryBlue,
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFF8FAFF),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFE1E6F0))
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row {
                    Text("Fecha programada", fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Text("Hora", fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Text("Motivo", fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                }

                Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFFE1E6F0))

                Row {
                    Text("20/05/2024", fontSize = 12.sp, color = Color(0xFF4B5878), modifier = Modifier.weight(1f))
                    Text("09:30 AM", fontSize = 12.sp, color = Color(0xFF4B5878), modifier = Modifier.weight(1f))
                    Text("Disponibilidad de técnico", fontSize = 12.sp, color = Color(0xFF4B5878), modifier = Modifier.weight(1f))
                }

                Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFFE1E6F0))

                Row {
                    Text("21/05/2024", fontSize = 12.sp, color = Color(0xFF4B5878), modifier = Modifier.weight(1f))
                    Text("09:30 AM", fontSize = 12.sp, color = Color(0xFF4B5878), modifier = Modifier.weight(1f))
                    Text("Actual", fontSize = 12.sp, color = primaryBlue, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFEAF2FF),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "ℹ No hay más reprogramaciones para esta orden.",
                color = Color(0xFF17213D),
                fontSize = 13.sp,
                modifier = Modifier.padding(14.dp)
            )
        }
    }
}

@Composable
private fun SectionCard(
    title: String,
    icon: String,
    primaryBlue: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
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

            Spacer(modifier = Modifier.height(14.dp))

            content()
        }
    }
}

@Composable
private fun InfoField(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    accentColor: Color = Color(0xFF17213D)
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

        Spacer(modifier = Modifier.height(6.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFFE1E6F0))
        ) {
            Text(
                text = value,
                color = accentColor,
                fontSize = 13.sp,
                lineHeight = 17.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
private fun InfoLine(
    label: String,
    value: String,
    modifier: Modifier = Modifier
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

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = Color(0xFF17213D),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}