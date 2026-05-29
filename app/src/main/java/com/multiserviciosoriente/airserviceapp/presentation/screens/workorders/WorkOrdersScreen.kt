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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WorkOrdersScreen(
    onBackClick: () -> Unit,
    onDetailClick: () -> Unit,
    onReportClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val textDark = Color(0xFF17213D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        TechnicianTopBar(
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
                text = "Inicio  ›  Órdenes de trabajo",
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
                                text = "🧾",
                                fontSize = 28.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Órdenes de Trabajo",
                                color = textDark,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Consulta tus órdenes asignadas y la programación de servicios.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp,
                                lineHeight = 19.sp
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "☰ Filtros",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Divider(color = Color(0xFFE1E6F0))

                    Spacer(modifier = Modifier.height(16.dp))

                    WeekSelector(primaryBlue = primaryBlue)

                    Spacer(modifier = Modifier.height(18.dp))

                    DaySelector(primaryBlue = primaryBlue)

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "📅 Martes, 21 de mayo, 2024",
                            color = textDark,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "4 órdenes asignadas",
                            color = primaryBlue,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    WorkOrderCard(
                        time = "09:30\nAM",
                        orderId = "#OT-2024-0128",
                        client = "María López Torres",
                        phone = "7123-4567",
                        equipment = "LG Dual Inverter",
                        detail = "18,000 BTU\nSN: LG18DI2023B009874\nSala principal",
                        status = "Pendiente",
                        statusColor = orange,
                        primaryBlue = primaryBlue,
                        onDetailClick = onDetailClick,
                        onReportClick = onReportClick
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    WorkOrderCard(
                        time = "12:00\nPM",
                        orderId = "#OT-2024-0129",
                        client = "Ana Rodríguez",
                        phone = "7345-6789",
                        equipment = "Panasonic Inverter",
                        detail = "24,000 BTU\nSN: PA24INV2023A11233\nOficina administrativa",
                        status = "Programada",
                        statusColor = primaryBlue,
                        primaryBlue = primaryBlue,
                        onDetailClick = onDetailClick,
                        onReportClick = onReportClick
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    WorkOrderCard(
                        time = "03:00\nPM",
                        orderId = "#OT-2024-0130",
                        client = "Carlos Méndez",
                        phone = "7234-5678",
                        equipment = "Midea",
                        detail = "9,000 BTU Frío/Calor\nSN: MD09HC2023C00654\nHabitación principal",
                        status = "Programada",
                        statusColor = primaryBlue,
                        primaryBlue = primaryBlue,
                        onDetailClick = onDetailClick,
                        onReportClick = onReportClick
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    WorkOrderCard(
                        time = "05:00\nPM",
                        orderId = "#OT-2024-0131",
                        client = "Roberto Sánchez",
                        phone = "7456-7890",
                        equipment = "Samsung",
                        detail = "WindFree 18,000 BTU\nSN: SA18WF2023D44321\nSala de reuniones",
                        status = "Pendiente",
                        statusColor = orange,
                        primaryBlue = primaryBlue,
                        onDetailClick = onDetailClick,
                        onReportClick = onReportClick
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        WorkOrderSummaryCard(
                            title = "Total órdenes",
                            value = "4",
                            icon = "📄",
                            color = primaryBlue
                        )

                        WorkOrderSummaryCard(
                            title = "Pendientes",
                            value = "2",
                            icon = "🕘",
                            color = orange
                        )

                        WorkOrderSummaryCard(
                            title = "Programadas",
                            value = "2",
                            icon = "📅",
                            color = green
                        )

                        WorkOrderSummaryCard(
                            title = "Completadas hoy",
                            value = "0",
                            icon = "✓",
                            color = green
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFEAF2FF),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Importante: Comunícate con tu supervisor si necesitas reprogramar alguna orden de trabajo.",
                            color = Color(0xFF17213D),
                            fontSize = 13.sp,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
private fun TechnicianTopBar(
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
                    text = "Mis Órdenes de Trabajo",
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
private fun WeekSelector(
    primaryBlue: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "‹",
                color = primaryBlue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Surface(
            modifier = Modifier.weight(1f),
            color = Color(0xFFF8FAFF),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color(0xFFE1E6F0))
        ) {
            Text(
                text = "20 - 26 de mayo, 2024",
                color = Color(0xFF17213D),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 13.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "›",
                color = primaryBlue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun DaySelector(
    primaryBlue: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DayItem(dayName = "Lun", dayNumber = "20", orders = "3 órdenes", selected = false, primaryBlue = primaryBlue)
        DayItem(dayName = "Mar", dayNumber = "21", orders = "4 órdenes", selected = true, primaryBlue = primaryBlue)
        DayItem(dayName = "Mié", dayNumber = "22", orders = "2 órdenes", selected = false, primaryBlue = primaryBlue)
        DayItem(dayName = "Jue", dayNumber = "23", orders = "3 órdenes", selected = false, primaryBlue = primaryBlue)
        DayItem(dayName = "Vie", dayNumber = "24", orders = "2 órdenes", selected = false, primaryBlue = primaryBlue)
        DayItem(dayName = "Sáb", dayNumber = "25", orders = "1 orden", selected = false, primaryBlue = primaryBlue)
        DayItem(dayName = "Dom", dayNumber = "26", orders = "0 órdenes", selected = false, primaryBlue = primaryBlue)
    }
}

@Composable
private fun DayItem(
    dayName: String,
    dayNumber: String,
    orders: String,
    selected: Boolean,
    primaryBlue: Color
) {
    Surface(
        modifier = Modifier.width(95.dp),
        color = if (selected) primaryBlue else Color.White,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, if (selected) primaryBlue else Color(0xFFE1E6F0))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dayName,
                color = if (selected) Color.White else Color(0xFF17213D),
                fontSize = 13.sp
            )

            Text(
                text = dayNumber,
                color = if (selected) Color.White else Color(0xFF17213D),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = orders,
                color = if (selected) Color.White.copy(alpha = 0.9f) else Color(0xFF5D6678),
                fontSize = 11.sp
            )
        }
    }
}

@Composable
private fun WorkOrderCard(
    time: String,
    orderId: String,
    client: String,
    phone: String,
    equipment: String,
    detail: String,
    status: String,
    statusColor: Color,
    primaryBlue: Color,
    onDetailClick: () -> Unit,
    onReportClick: () -> Unit
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
                Text(
                    text = time,
                    color = Color(0xFF17213D),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                    modifier = Modifier.width(74.dp)
                )

                Divider(
                    modifier = Modifier
                        .height(82.dp)
                        .width(1.dp),
                    color = Color(0xFFE1E6F0)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = orderId,
                        color = primaryBlue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = client,
                        color = Color(0xFF17213D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = phone,
                        color = Color(0xFF4B5878),
                        fontSize = 12.sp
                    )
                }

                Column(
                    modifier = Modifier.weight(1.2f)
                ) {
                    Text(
                        text = equipment,
                        color = Color(0xFF17213D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = detail,
                        color = Color(0xFF4B5878),
                        fontSize = 12.sp,
                        lineHeight = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatusBadge(
                    text = status,
                    color = statusColor
                )

                Spacer(modifier = Modifier.weight(1f))

                OutlinedButton(
                    onClick = onDetailClick,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, primaryBlue.copy(alpha = 0.45f))
                ) {
                    Text(
                        text = "Ver detalle",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onReportClick,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, primaryBlue.copy(alpha = 0.45f))
                ) {
                    Text(
                        text = "Reporte",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun WorkOrderSummaryCard(
    title: String,
    value: String,
    icon: String,
    color: Color
) {
    Surface(
        modifier = Modifier
            .width(180.dp)
            .height(86.dp),
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
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.13f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = title,
                    color = Color(0xFF4B5878),
                    fontSize = 12.sp
                )

                Text(
                    text = value,
                    color = Color(0xFF17213D),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
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