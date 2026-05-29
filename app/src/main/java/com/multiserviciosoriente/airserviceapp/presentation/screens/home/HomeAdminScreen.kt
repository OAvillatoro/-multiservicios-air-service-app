package com.multiserviciosoriente.airserviceapp.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.multiserviciosoriente.airserviceapp.R

@Composable
fun HomeAdminScreen(
    onRequestInboxClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val textDark = Color(0xFF17213D)

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FB))
    ) {
        AdminSideMenu(
            primaryBlue = primaryBlue,
            onRequestInboxClick = onRequestInboxClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AdminTopBar(
                primaryBlue = primaryBlue,
                darkBlue = darkBlue
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    color = primaryBlue,
                    shadowElevation = 4.dp
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    listOf(
                                        primaryBlue,
                                        Color(0xFF005BC7)
                                    )
                                )
                            )
                            .padding(22.dp)
                    ) {
                        Column {
                            Text(
                                text = "Administración central de",
                                color = Color.White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "servicios de mantenimiento",
                                color = Color.White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "de aire acondicionado",
                                color = Color.White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(5.dp)
                                    .background(orange, RoundedCornerShape(50.dp))
                            )
                        }

                        Text(
                            text = "❄️",
                            color = Color.White,
                            fontSize = 58.sp,
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DashboardMetricCard(
                        icon = "📋",
                        value = "28",
                        label = "Solicitudes\npendientes",
                        action = "Ver todas",
                        color = primaryBlue,
                        modifier = Modifier.weight(1f),
                        onClick = onRequestInboxClick
                    )

                    DashboardMetricCard(
                        icon = "📅",
                        value = "12",
                        label = "Servicios\nprogramados hoy",
                        action = "Ver agenda",
                        color = Color(0xFF00865A),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    DashboardMetricCard(
                        icon = "👷",
                        value = "8",
                        label = "Técnicos\ndisponibles",
                        action = "Ver técnicos",
                        color = orange,
                        modifier = Modifier.weight(1f)
                    )

                    DashboardMetricCard(
                        icon = "✅",
                        value = "156",
                        label = "Servicios\nfinalizados",
                        action = "Ver reportes",
                        color = Color(0xFF6B4EFF),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    InfoWideCard(
                        icon = "$",
                        title = "$4,250.00",
                        subtitle = "Monto sugerido del mes\n(servicios finalizados)",
                        action = "Ver detalle",
                        color = primaryBlue,
                        modifier = Modifier.weight(1f)
                    )

                    InfoWideCard(
                        icon = "↗",
                        title = "+18%",
                        subtitle = "Comparado con el\nmes anterior",
                        action = "Ver estadísticas",
                        color = orange,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                RecentRequestsCard(
                    primaryBlue = primaryBlue,
                    orange = orange,
                    textDark = textDark,
                    onRequestInboxClick = onRequestInboxClick
                )

                Spacer(modifier = Modifier.height(18.dp))

                TodayScheduleCard(
                    primaryBlue = primaryBlue,
                    textDark = textDark
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun AdminSideMenu(
    primaryBlue: Color,
    onRequestInboxClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .width(250.dp)
            .fillMaxHeight(),
        color = Color.White,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_multiservicios_oriente),
                contentDescription = "Logo MultiServicios de Oriente",
                modifier = Modifier
                    .size(145.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(primaryBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "👤",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = "Admin Sistema",
                        color = Color(0xFF17213D),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Administrador",
                        color = primaryBlue,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "● En línea",
                        color = Color(0xFF00865A),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "NAVEGACIÓN",
                color = Color.Gray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            MenuItem(
                icon = "🏠",
                text = "Inicio",
                selected = true,
                primaryBlue = primaryBlue
            )

            MenuItem("▦", "Panel de control", false, primaryBlue)
            MenuItem("👥", "Usuarios", false, primaryBlue)
            MenuItem("👤", "Clientes", false, primaryBlue)
            MenuItem("▣", "Equipos", false, primaryBlue)

            MenuItem(
                icon = "📋",
                text = "Solicitudes",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onRequestInboxClick
            )

            MenuItem("💼", "Órdenes de trabajo", false, primaryBlue)
            MenuItem("📅", "Reprogramaciones", false, primaryBlue)
            MenuItem("📄", "Reportes y servicios", false, primaryBlue)
            MenuItem("🔔", "Notificaciones", false, primaryBlue)
            MenuItem("⚙", "Configuración", false, primaryBlue)
            MenuItem("❄", "Tipos de equipo", false, primaryBlue)
            MenuItem("⏱", "Periodicidades", false, primaryBlue)
            MenuItem("💾", "Respaldo de datos", false, primaryBlue)
            MenuItem("ⓘ", "Acerca de la app", false, primaryBlue)

            Spacer(modifier = Modifier.weight(1f))

            MenuItem(
                icon = "↪",
                text = "Cerrar sesión",
                selected = false,
                primaryBlue = Color(0xFFD92525)
            )
        }
    }
}

@Composable
private fun MenuItem(
    icon: String,
    text: String,
    selected: Boolean,
    primaryBlue: Color,
    onClick: () -> Unit = {}
) {
    val backgroundColor = if (selected) primaryBlue else Color.Transparent
    val contentColor = if (selected) Color.White else Color(0xFF17213D)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 18.sp,
            color = contentColor
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            fontSize = 15.sp,
            color = contentColor
        )
    }
}

@Composable
private fun AdminTopBar(
    primaryBlue: Color,
    darkBlue: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        darkBlue,
                        primaryBlue
                    )
                )
            )
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "☰",
            color = Color.White,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "¡Bienvenido, Admin!",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "🔍",
            color = Color.White,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = "🔔",
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

@Composable
private fun DashboardMetricCard(
    icon: String,
    value: String,
    label: String,
    action: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                color = color,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color(0xFF17213D),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "$action ›",
                color = Color(0xFF004AC2),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun InfoWideCard(
    icon: String,
    title: String,
    subtitle: String,
    action: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(62.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = title,
                    color = color,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = subtitle,
                    color = Color(0xFF5D6678),
                    fontSize = 14.sp,
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$action ›",
                    color = Color(0xFF004AC2),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun RecentRequestsCard(
    primaryBlue: Color,
    orange: Color,
    textDark: Color,
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
                    text = "Solicitudes más recientes",
                    color = textDark,
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

            Spacer(modifier = Modifier.height(12.dp))

            RequestRow("Juan Pérez", "Samsung WindFree 12000 BTU", "Preventivo", "Hoy, 8:30 a. m.", "Creada", orange)
            Divider()
            RequestRow("María Gómez", "LG Dual Inverter 18000 BTU", "Correctivo - No enfría", "Ayer, 4:15 p. m.", "Creada", orange)
            Divider()
            RequestRow("Carlos Ramírez", "Mabe 12000 BTU", "Preventivo", "Ayer, 11:20 a. m.", "En revisión", orange)
        }
    }
}

@Composable
private fun RequestRow(
    client: String,
    equipment: String,
    serviceType: String,
    date: String,
    status: String,
    orange: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
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
                fontSize = 13.sp
            )

            Surface(
                color = orange.copy(alpha = 0.14f),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = status,
                    color = orange,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun TodayScheduleCard(
    primaryBlue: Color,
    textDark: Color
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
                    text = "Agenda de hoy",
                    color = textDark,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Ver agenda completa",
                    color = primaryBlue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            ScheduleRow("09:00 a. m.", "Ana Torres", "Daikin Inverter 24000 BTU", "Preventivo", "Carlos Martínez")
            Divider()
            ScheduleRow("11:30 a. m.", "Roberto Flores", "Mirage 12000 BTU", "Correctivo", "Luis Hernández")
            Divider()
            ScheduleRow("02:30 p. m.", "Lucía Méndez", "Samsung WindFree 12000 BTU", "Preventivo", "Mario López")
        }
    }
}

@Composable
private fun ScheduleRow(
    time: String,
    client: String,
    equipment: String,
    serviceType: String,
    technician: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            color = Color(0xFF00865A),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(88.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
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
            Surface(
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = "Programado",
                    color = Color(0xFF004AC2),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }

            Text(
                text = "Técnico:",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Text(
                text = technician,
                color = Color(0xFF17213D),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}