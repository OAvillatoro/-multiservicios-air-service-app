package com.multiserviciosoriente.airserviceapp.presentation.screens.home

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.multiserviciosoriente.airserviceapp.R

@Composable
fun HomeClientScreen(
    onEquipmentListClick: () -> Unit,
    onServiceRequestClick: () -> Unit,
    onHistoryClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val textDark = Color(0xFF17213D)
    val green = Color(0xFF00865A)

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
                        text = "¡Hola, Juan Pérez!",
                        color = textDark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Cliente",
                        color = primaryBlue,
                        fontSize = 17.sp,
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
                            text = "3",
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
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Bienvenido a MultiServicios de Oriente",
                            color = textDark,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 25.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Gestiona tus equipos de aire acondicionado y solicita mantenimientos fácilmente.",
                            color = Color(0xFF4B5878),
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )
                    }

                    Text(
                        text = "❄️",
                        fontSize = 54.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ClientOptionCard(
                    icon = "❄️",
                    title = "Mis Equipos",
                    subtitle = "Ver y gestionar tus equipos",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f),
                    onClick = onEquipmentListClick
                )

                ClientOptionCard(
                    icon = "📋",
                    title = "Solicitar Mantenimiento",
                    subtitle = "Crea una nueva solicitud",
                    color = green,
                    modifier = Modifier.weight(1f),
                    onClick = onServiceRequestClick
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ClientOptionCard(
                    icon = "📄",
                    title = "Mis Solicitudes",
                    subtitle = "Consulta el estado de tus solicitudes",
                    color = orange,
                    modifier = Modifier.weight(1f),
                    onClick = onHistoryClick
                )

                ClientOptionCard(
                    icon = "👤",
                    title = "Mi Perfil",
                    subtitle = "Actualiza tus datos personales",
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
                    text = "Mis Equipos",
                    color = textDark,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onEquipmentListClick) {
                    Text(
                        text = "⊕ Agregar equipo",
                        color = primaryBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            EquipmentPreviewCard(
                brand = "Samsung",
                model = "WindFree 12,000 BTU",
                type = "Minisplit Inverter",
                location = "Sala principal",
                lastMaintenance = "15 abr. 2024",
                nextMaintenance = "15 oct. 2024",
                icon = "❄️",
                primaryBlue = primaryBlue,
                green = green,
                onDetailClick = onEquipmentListClick,
                onRequestClick = onServiceRequestClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            EquipmentPreviewCard(
                brand = "LG",
                model = "Dual Inverter 18,000 BTU",
                type = "Minisplit Inverter",
                location = "Habitación principal",
                lastMaintenance = "20 feb. 2024",
                nextMaintenance = "20 ago. 2024",
                icon = "▤",
                primaryBlue = primaryBlue,
                green = green,
                onDetailClick = onEquipmentListClick,
                onRequestClick = onServiceRequestClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            EquipmentPreviewCard(
                brand = "Midea",
                model = "9,000 BTU Frío/Calor",
                type = "Ventana",
                location = "Oficina",
                lastMaintenance = "10 mar. 2024",
                nextMaintenance = "10 sep. 2024",
                icon = "▣",
                primaryBlue = primaryBlue,
                green = green,
                onDetailClick = onEquipmentListClick,
                onRequestClick = onServiceRequestClick
            )

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ℹ️",
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Mantener tus equipos al día asegura su buen funcionamiento y mayor vida útil.",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        ClientBottomNavigation(
            primaryBlue = primaryBlue,
            onEquipmentListClick = onEquipmentListClick,
            onServiceRequestClick = onServiceRequestClick,
            onHistoryClick = onHistoryClick
        )
    }
}

@Composable
private fun ClientOptionCard(
    icon: String,
    title: String,
    subtitle: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .height(155.dp)
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

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                color = Color(0xFF17213D),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 19.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = subtitle,
                color = Color(0xFF5D6678),
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                lineHeight = 17.sp
            )
        }
    }
}

@Composable
private fun EquipmentPreviewCard(
    brand: String,
    model: String,
    type: String,
    location: String,
    lastMaintenance: String,
    nextMaintenance: String,
    icon: String,
    primaryBlue: Color,
    green: Color,
    onDetailClick: () -> Unit,
    onRequestClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFEAF2FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = icon,
                        color = primaryBlue,
                        fontSize = 34.sp
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = brand,
                        color = Color(0xFF17213D),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Modelo: $model",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Tipo: $type",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Ubicación: $location",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = "⋮",
                    color = Color(0xFF17213D),
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Último mantenimiento",
                        color = Color(0xFF5D6678),
                        fontSize = 13.sp
                    )

                    Text(
                        text = "📅 $lastMaintenance",
                        color = Color(0xFF17213D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Próximo mantenimiento",
                        color = Color(0xFF5D6678),
                        fontSize = 13.sp
                    )

                    Text(
                        text = "📅 $nextMaintenance",
                        color = green,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onDetailClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Ver detalle",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onRequestClick,
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Solicitar mantenimiento",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onDetailClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Editar",
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
private fun ClientBottomNavigation(
    primaryBlue: Color,
    onEquipmentListClick: () -> Unit,
    onServiceRequestClick: () -> Unit,
    onHistoryClick: () -> Unit
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
            BottomNavItem(
                icon = "🏠",
                label = "Inicio",
                selected = true,
                primaryBlue = primaryBlue
            )

            BottomNavItem(
                icon = "❄️",
                label = "Mis Equipos",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onEquipmentListClick
            )

            BottomNavItem(
                icon = "＋",
                label = "Solicitar",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onServiceRequestClick
            )

            BottomNavItem(
                icon = "📋",
                label = "Solicitudes",
                selected = false,
                primaryBlue = primaryBlue,
                onClick = onHistoryClick
            )

            BottomNavItem(
                icon = "👤",
                label = "Mi Perfil",
                selected = false,
                primaryBlue = primaryBlue
            )
        }
    }
}

@Composable
private fun BottomNavItem(
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