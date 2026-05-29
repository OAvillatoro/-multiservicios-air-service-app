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
fun HomeManagerScreen(
    onRequestInboxClick: () -> Unit
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
                        text = "¡Hola, Encargado!",
                        color = textDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Gestión operativa de servicios",
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
                            text = "5",
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
                            text = "Panel del Encargado",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Administra solicitudes, programa visitas, asigna técnicos y da seguimiento a los servicios.",
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
                        text = "📋",
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
                ManagerMetricCard(
                    icon = "📥",
                    value = "18",
                    label = "Solicitudes\nrecibidas",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f),
                    onClick = onRequestInboxClick
                )

                ManagerMetricCard(
                    icon = "🕒",
                    value = "7",
                    label = "Pendientes de\nprogramar",
                    color = orange,
                    modifier = Modifier.weight(1f),
                    onClick = onRequestInboxClick
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ManagerMetricCard(
                    icon = "👷",
                    value = "6",
                    label = "Técnicos\nactivos",
                    color = green,
                    modifier = Modifier.weight(1f)
                )

                ManagerMetricCard(
                    icon = "✅",
                    value = "11",
                    label = "Servicios\ncerrados hoy",
                    color = Color(0xFF6B4EFF),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Acciones principales",
                color = textDark,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            ManagerActionCard(
                icon = "📥",
                title = "Bandeja de solicitudes",
                description = "Revisar solicitudes enviadas por clientes y dar seguimiento al estado.",
                actionText = "Revisar solicitudes",
                color = primaryBlue,
                onClick = onRequestInboxClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            ManagerActionCard(
                icon = "📅",
                title = "Programar visitas",
                description = "Definir fecha y hora oficial del servicio según disponibilidad.",
                actionText = "Programar",
                color = green,
                onClick = onRequestInboxClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            ManagerActionCard(
                icon = "👷",
                title = "Asignar técnicos",
                description = "Seleccionar el técnico responsable para atender cada orden de trabajo.",
                actionText = "Asignar técnico",
                color = orange,
                onClick = onRequestInboxClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            ManagerActionCard(
                icon = "🔁",
                title = "Reprogramaciones",
                description = "Gestionar cambios de fecha u hora cuando el cliente o técnico lo solicite.",
                actionText = "Ver reprogramaciones",
                color = Color(0xFF6B4EFF),
                onClick = onRequestInboxClick
            )

            Spacer(modifier = Modifier.height(22.dp))

            RecentManagerRequests(
                primaryBlue = primaryBlue,
                orange = orange,
                green = green,
                onRequestInboxClick = onRequestInboxClick
            )

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
                        text = "El encargado puede revisar solicitudes, programar visitas, asignar técnicos, reprogramar servicios y finalizar administrativamente las órdenes.",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        ManagerBottomNavigation(
            primaryBlue = primaryBlue,
            onRequestInboxClick = onRequestInboxClick
        )
    }
}

@Composable
private fun ManagerMetricCard(
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
private fun ManagerActionCard(
    icon: String,
    title: String,
    description: String,
    actionText: String,
    color: Color,
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
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.13f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 28.sp
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    color = Color(0xFF17213D),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    color = Color(0xFF5D6678),
                    fontSize = 14.sp,
                    lineHeight = 19.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "$actionText ›",
                    color = color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun RecentManagerRequests(
    primaryBlue: Color,
    orange: Color,
    green: Color,
    onRequestInboxClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Solicitudes recientes",
                    color = Color(0xFF17213D),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Ver todas",
                    color = primaryBlue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onRequestInboxClick() }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            ManagerRequestRow(
                client = "Juan Pérez",
                equipment = "Samsung WindFree 12,000 BTU",
                serviceType = "Preventivo",
                date = "Hoy, 8:30 a. m.",
                status = "Pendiente",
                statusColor = orange
            )

            Divider()

            ManagerRequestRow(
                client = "María Gómez",
                equipment = "LG Dual Inverter 18,000 BTU",
                serviceType = "Correctivo - No enfría",
                date = "Hoy, 10:15 a. m.",
                status = "En revisión",
                statusColor = primaryBlue
            )

            Divider()

            ManagerRequestRow(
                client = "Carlos Ramírez",
                equipment = "Mabe 12,000 BTU",
                serviceType = "Preventivo",
                date = "Mañana, 2:00 p. m.",
                status = "Programada",
                statusColor = green
            )
        }
    }
}

@Composable
private fun ManagerRequestRow(
    client: String,
    equipment: String,
    serviceType: String,
    date: String,
    status: String,
    statusColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "📋",
            fontSize = 26.sp
        )

        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = client,
                color = Color(0xFF17213D),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = equipment,
                color = Color(0xFF5D6678),
                fontSize = 13.sp
            )

            Text(
                text = serviceType,
                color = Color(0xFF17213D),
                fontSize = 13.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = date,
                color = Color(0xFF5D6678),
                fontSize = 12.sp
            )

            Surface(
                color = statusColor.copy(alpha = 0.13f),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = status,
                    color = statusColor,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun ManagerBottomNavigation(
    primaryBlue: Color,
    onRequestInboxClick: () -> Unit
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
            ManagerBottomNavItem(
                icon = "🏠",
                label = "Inicio",
                selected = true,
                primaryBlue = primaryBlue
            )

            ManagerBottomNavItem(
                icon = "📥",
                label = "Solicitudes",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onRequestInboxClick
            )

            ManagerBottomNavItem(
                icon = "📅",
                label = "Agenda",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onRequestInboxClick
            )

            ManagerBottomNavItem(
                icon = "👷",
                label = "Técnicos",
                selected = false,
                primaryBlue = primaryBlue
            )

            ManagerBottomNavItem(
                icon = "📄",
                label = "Reportes",
                selected = false,
                primaryBlue = primaryBlue
            )
        }
    }
}

@Composable
private fun ManagerBottomNavItem(
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