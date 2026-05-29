package com.multiserviciosoriente.airserviceapp.presentation.screens.requests

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RequestInboxScreen(
    onBackClick: () -> Unit,
    onScheduleClick: () -> Unit,
    onDetailClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val red = Color(0xFFE53935)
    val purple = Color(0xFF7E3FF2)
    val textDark = Color(0xFF17213D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        AdminTopBar(
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
                text = "Inicio  ›  Solicitudes  ›  Bandeja de solicitudes",
                color = Color(0xFF4B5878),
                fontSize = 14.sp
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
                                .size(58.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(primaryBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "📋",
                                fontSize = 28.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Bandeja de Solicitudes",
                                color = textDark,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Administre y dé seguimiento a las solicitudes de mantenimiento enviadas por los clientes.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp,
                                lineHeight = 19.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "☰ Filtros",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1.25f),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryBlue
                            )
                        ) {
                            Text(
                                text = "+ Nueva solicitud",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        RequestSummaryCard(
                            title = "Total solicitudes",
                            value = "24",
                            icon = "📄",
                            color = primaryBlue
                        )

                        RequestSummaryCard(
                            title = "Pendientes",
                            value = "8",
                            icon = "🕘",
                            color = orange
                        )

                        RequestSummaryCard(
                            title = "Programadas",
                            value = "10",
                            icon = "📅",
                            color = green
                        )

                        RequestSummaryCard(
                            title = "En proceso",
                            value = "4",
                            icon = "🧑‍🔧",
                            color = purple
                        )

                        RequestSummaryCard(
                            title = "Completadas",
                            value = "2",
                            icon = "✓",
                            color = textDark
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    RequestListTable(
                        primaryBlue = primaryBlue,
                        orange = orange,
                        green = green,
                        red = red,
                        onScheduleClick = onScheduleClick,
                        onDetailClick = onDetailClick
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    ActionLegend(
                        primaryBlue = primaryBlue,
                        orange = orange,
                        red = red
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
private fun AdminTopBar(
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
private fun RequestSummaryCard(
    title: String,
    value: String,
    icon: String,
    color: Color
) {
    Surface(
        modifier = Modifier
            .width(190.dp)
            .height(92.dp),
        color = Color.White,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0)),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.13f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = title,
                    color = Color(0xFF4B5878),
                    fontSize = 13.sp
                )

                Text(
                    text = value,
                    color = Color(0xFF17213D),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun RequestListTable(
    primaryBlue: Color,
    orange: Color,
    green: Color,
    red: Color,
    onScheduleClick: () -> Unit,
    onDetailClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        RequestCard(
            requestId = "#SOL-2024-0058",
            date = "15/05/2024",
            client = "Juan Pérez García",
            phone = "7000-0000",
            equipment = "Samsung WindFree 12,000 BTU",
            serial = "SA12WF2024A001256",
            serviceType = "Mantenimiento preventivo",
            preferredDate = "20/05/2024",
            preferredTime = "09:00 AM",
            status = "Pendiente",
            statusColor = orange,
            primaryBlue = primaryBlue,
            red = red,
            onScheduleClick = onScheduleClick,
            onDetailClick = onDetailClick
        )

        Spacer(modifier = Modifier.height(10.dp))

        RequestCard(
            requestId = "#SOL-2024-0057",
            date = "14/05/2024",
            client = "María López Torres",
            phone = "7123-4567",
            equipment = "LG Dual Inverter 18,000 BTU",
            serial = "LG18DI2023B009874",
            serviceType = "Mantenimiento correctivo",
            preferredDate = "18/05/2024",
            preferredTime = "02:00 PM",
            status = "Programada",
            statusColor = primaryBlue,
            primaryBlue = primaryBlue,
            red = red,
            onScheduleClick = onScheduleClick,
            onDetailClick = onDetailClick
        )

        Spacer(modifier = Modifier.height(10.dp))

        RequestCard(
            requestId = "#SOL-2024-0056",
            date = "14/05/2024",
            client = "Carlos Méndez",
            phone = "7234-5678",
            equipment = "Midea 9,000 BTU Frío/Calor",
            serial = "MD09HC2023C00654",
            serviceType = "Mantenimiento correctivo",
            preferredDate = "16/05/2024",
            preferredTime = "10:00 AM",
            status = "En proceso",
            statusColor = green,
            primaryBlue = primaryBlue,
            red = red,
            onScheduleClick = onScheduleClick,
            onDetailClick = onDetailClick
        )

        Spacer(modifier = Modifier.height(10.dp))

        RequestCard(
            requestId = "#SOL-2024-0055",
            date = "13/05/2024",
            client = "Ana Rodríguez",
            phone = "7345-6789",
            equipment = "Panasonic Inverter 24,000 BTU",
            serial = "PA24INV2023A11233",
            serviceType = "Mantenimiento preventivo",
            preferredDate = "22/05/2024",
            preferredTime = "11:00 AM",
            status = "Pendiente",
            statusColor = orange,
            primaryBlue = primaryBlue,
            red = red,
            onScheduleClick = onScheduleClick,
            onDetailClick = onDetailClick
        )

        Spacer(modifier = Modifier.height(10.dp))

        RequestCard(
            requestId = "#SOL-2024-0054",
            date = "12/05/2024",
            client = "Roberto Sánchez",
            phone = "7456-7890",
            equipment = "Samsung WindFree 18,000 BTU",
            serial = "SA18WF2023D44321",
            serviceType = "Mantenimiento correctivo",
            preferredDate = "17/05/2024",
            preferredTime = "03:00 PM",
            status = "Completada",
            statusColor = Color(0xFF667085),
            primaryBlue = primaryBlue,
            red = red,
            onScheduleClick = onScheduleClick,
            onDetailClick = onDetailClick
        )

        Spacer(modifier = Modifier.height(14.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFF8FAFF),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFE1E6F0))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mostrando 1 a 5 de 24 solicitudes",
                    color = Color(0xFF4B5878),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "‹‹   1   2   3   ...   5   ››",
                    color = primaryBlue,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun RequestCard(
    requestId: String,
    date: String,
    client: String,
    phone: String,
    equipment: String,
    serial: String,
    serviceType: String,
    preferredDate: String,
    preferredTime: String,
    status: String,
    statusColor: Color,
    primaryBlue: Color,
    red: Color,
    onScheduleClick: () -> Unit,
    onDetailClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0)),
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = requestId,
                        color = primaryBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = date,
                        color = Color(0xFF5D6678),
                        fontSize = 12.sp
                    )
                }

                StatusBadge(
                    text = status,
                    color = statusColor
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider()

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    InfoLabelValue(
                        label = "Cliente",
                        value = client,
                        secondary = phone
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InfoLabelValue(
                        label = "Equipo",
                        value = equipment,
                        secondary = "SN: $serial"
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    InfoLabelValue(
                        label = "Tipo de mantenimiento",
                        value = serviceType,
                        secondary = ""
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    InfoLabelValue(
                        label = "Fecha preferida",
                        value = preferredDate,
                        secondary = preferredTime
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SmallActionButton(
                    text = "Ver",
                    color = primaryBlue,
                    onClick = onDetailClick,
                    modifier = Modifier.weight(1f)
                )

                SmallActionButton(
                    text = "Programar",
                    color = primaryBlue,
                    onClick = onScheduleClick,
                    modifier = Modifier.weight(1.2f)
                )

                SmallActionButton(
                    text = "Asignar",
                    color = primaryBlue,
                    onClick = onScheduleClick,
                    modifier = Modifier.weight(1f)
                )

                SmallActionButton(
                    text = "Cancelar",
                    color = red,
                    onClick = {},
                    modifier = Modifier.weight(1.1f)
                )
            }
        }
    }
}

@Composable
private fun InfoLabelValue(
    label: String,
    value: String,
    secondary: String
) {
    Text(
        text = label,
        color = Color(0xFF5D6678),
        fontSize = 12.sp
    )

    Text(
        text = value,
        color = Color(0xFF17213D),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp
    )

    if (secondary.isNotBlank()) {
        Text(
            text = secondary,
            color = Color(0xFF4B5878),
            fontSize = 12.sp,
            lineHeight = 16.sp
        )
    }
}

@Composable
private fun StatusBadge(
    text: String,
    color: Color
) {
    Surface(
        color = color.copy(alpha = 0.12f),
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(1.dp, color.copy(alpha = 0.35f))
    ) {
        Text(
            text = text,
            color = color,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
private fun SmallActionButton(
    text: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(42.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color.copy(alpha = 0.45f))
    ) {
        Text(
            text = text,
            color = color,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ActionLegend(
    primaryBlue: Color,
    orange: Color,
    red: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFEAF2FF),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Text(
                text = "Acciones disponibles",
                color = Color(0xFF17213D),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LegendItem(
                    icon = "👁",
                    title = "Revisar",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f)
                )

                LegendItem(
                    icon = "📅",
                    title = "Programar",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f)
                )

                LegendItem(
                    icon = "👷",
                    title = "Asignar",
                    color = orange,
                    modifier = Modifier.weight(1f)
                )

                LegendItem(
                    icon = "🗑",
                    title = "Cancelar",
                    color = red,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun LegendItem(
    icon: String,
    title: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = icon,
            fontSize = 20.sp
        )

        Text(
            text = title,
            color = color,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

