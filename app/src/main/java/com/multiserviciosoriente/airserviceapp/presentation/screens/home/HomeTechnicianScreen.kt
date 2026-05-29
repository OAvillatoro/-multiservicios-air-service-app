package com.multiserviciosoriente.airserviceapp.presentation.screens.home

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
fun HomeTechnicianScreen(
    onWorkOrdersClick: () -> Unit
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
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "☰",
                    color = darkBlue,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )

                Column(
                    modifier = Modifier.padding(start = 22.dp)
                ) {
                    Text(
                        text = "¡Hola, Carlos!",
                        color = textDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Técnico de mantenimiento",
                        color = primaryBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box {
                    Text(
                        text = "🔔",
                        fontSize = 30.sp
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE53935)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "2",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(20.dp),
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    darkBlue,
                                    primaryBlue
                                )
                            )
                        )
                        .padding(22.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Panel del Técnico",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Consulta tus órdenes asignadas, atiende servicios y registra el reporte final del trabajo realizado.",
                            color = Color.White.copy(alpha = 0.92f),
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(5.dp)
                                .background(orange, RoundedCornerShape(50.dp))
                        )
                    }

                    Text(
                        text = "👷",
                        color = Color.White,
                        fontSize = 58.sp,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TechnicianMetricCard(
                    icon = "📋",
                    value = "5",
                    label = "Órdenes\nasignadas",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f),
                    onClick = onWorkOrdersClick
                )

                TechnicianMetricCard(
                    icon = "📅",
                    value = "3",
                    label = "Servicios\npara hoy",
                    color = green,
                    modifier = Modifier.weight(1f),
                    onClick = onWorkOrdersClick
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TechnicianMetricCard(
                    icon = "🔧",
                    value = "1",
                    label = "En\nproceso",
                    color = orange,
                    modifier = Modifier.weight(1f),
                    onClick = onWorkOrdersClick
                )

                TechnicianMetricCard(
                    icon = "✅",
                    value = "12",
                    label = "Finalizadas\neste mes",
                    color = Color(0xFF6B4EFF),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Órdenes de hoy",
                    color = textDark,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onWorkOrdersClick) {
                    Text(
                        text = "Ver todas",
                        color = primaryBlue,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            TechnicianOrderCard(
                time = "09:00 a. m.",
                client = "Ana Torres",
                equipment = "Daikin Inverter 24,000 BTU",
                address = "Col. San Antonio, San Miguel",
                serviceType = "Preventivo",
                status = "Programado",
                statusColor = primaryBlue,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            TechnicianOrderCard(
                time = "11:30 a. m.",
                client = "Roberto Flores",
                equipment = "Mirage 12,000 BTU",
                address = "Barrio El Centro, San Miguel",
                serviceType = "Correctivo - No enfría",
                status = "En proceso",
                statusColor = orange,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            TechnicianOrderCard(
                time = "02:30 p. m.",
                client = "Lucía Méndez",
                equipment = "Samsung WindFree 12,000 BTU",
                address = "Residencial Las Flores",
                serviceType = "Preventivo",
                status = "Pendiente",
                statusColor = green,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            Spacer(modifier = Modifier.height(22.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 3.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Text(
                        text = "Resumen de actividades",
                        color = textDark,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    TechnicianActivityRow(
                        icon = "✅",
                        title = "Servicio finalizado",
                        description = "Mantenimiento preventivo registrado para equipo Samsung.",
                        time = "Ayer, 4:30 p. m.",
                        color = green
                    )

                    Divider()

                    TechnicianActivityRow(
                        icon = "🔁",
                        title = "Servicio reprogramado",
                        description = "Cliente solicitó cambio de horario para la visita técnica.",
                        time = "Ayer, 10:15 a. m.",
                        color = orange
                    )

                    Divider()

                    TechnicianActivityRow(
                        icon = "📋",
                        title = "Nueva orden asignada",
                        description = "Se asignó una orden correctiva para equipo Mirage.",
                        time = "Hoy, 8:00 a. m.",
                        color = primaryBlue
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ℹ️",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "El técnico debe actualizar el estado de la orden y registrar el reporte final al terminar el servicio.",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        TechnicianBottomNavigation(
            primaryBlue = primaryBlue,
            onWorkOrdersClick = onWorkOrdersClick
        )
    }
}

@Composable
private fun TechnicianMetricCard(
    icon: String,
    value: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .height(145.dp)
            .clickable { onClick() },
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.13f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 26.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                color = color,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color(0xFF17213D),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
private fun TechnicianOrderCard(
    time: String,
    client: String,
    equipment: String,
    address: String,
    serviceType: String,
    status: String,
    statusColor: Color,
    primaryBlue: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = time,
                        color = statusColor,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = client,
                        color = Color(0xFF17213D),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = equipment,
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = serviceType,
                        color = Color(0xFF17213D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Surface(
                    color = statusColor.copy(alpha = 0.13f),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = status,
                        color = statusColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "📍 $address",
                color = Color(0xFF5D6678),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Ver orden",
                        color = primaryBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Reporte final",
                        color = primaryBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun TechnicianActivityRow(
    icon: String,
    title: String,
    description: String,
    time: String,
    color: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 11.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.13f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 21.sp
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = title,
                color = Color(0xFF17213D),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                color = Color(0xFF5D6678),
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }

        Text(
            text = time,
            color = Color.Gray,
            fontSize = 11.sp,
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun TechnicianBottomNavigation(
    primaryBlue: Color,
    onWorkOrdersClick: () -> Unit
) {
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
                .height(72.dp)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TechnicianBottomNavItem(
                icon = "🏠",
                label = "Inicio",
                selected = true,
                primaryBlue = primaryBlue
            )

            TechnicianBottomNavItem(
                icon = "📋",
                label = "Órdenes",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            TechnicianBottomNavItem(
                icon = "🔧",
                label = "En proceso",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            TechnicianBottomNavItem(
                icon = "📄",
                label = "Reportes",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onWorkOrdersClick
            )

            TechnicianBottomNavItem(
                icon = "👤",
                label = "Perfil",
                selected = false,
                primaryBlue = primaryBlue
            )
        }
    }
}

@Composable
private fun TechnicianBottomNavItem(
    icon: String,
    label: String,
    selected: Boolean,
    primaryBlue: Color,
    onClick: () -> Unit = {}
) {
    val color = if (selected) primaryBlue else Color(0xFF5D6678)

    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = icon,
            fontSize = 22.sp
        )

        Text(
            text = label,
            color = color,
            fontSize = 12.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}